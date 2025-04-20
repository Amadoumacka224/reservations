package be.iccbxl.pid.reservationsspringboot.controller;

import be.iccbxl.pid.reservationsspringboot.model.Artist;
import be.iccbxl.pid.reservationsspringboot.model.ArtistType;
import be.iccbxl.pid.reservationsspringboot.model.Show;
import be.iccbxl.pid.reservationsspringboot.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ShowController {
    @Autowired
    ShowService service;

    @GetMapping("/shows")
    public String index(Model model) {
        List<Show> shows = service.getAll();

        model.addAttribute("shows", shows);
        model.addAttribute("title", "Liste des spectacles");

        return "show/index";
    }

    // En stage Nouvelle méthode pour retourner les spectacles en JSON
    @GetMapping("/json/shows")
    @ResponseBody

    public ResponseEntity<List<Map<String, Object>>> getAllShowsJson() {
        List<Show> shows = service.getAll();

        List<Map<String, Object>> result = shows.stream().map(show -> {
            Map<String, Object> showMap = new LinkedHashMap<>();

            // Propriétés de base du spectacle
            showMap.put("id", show.getId());
            showMap.put("title", show.getTitle());
            showMap.put("description", show.getDescription());

            showMap.put("posterUrl", show.getPosterUrl());

            // Gestion des artistes par type
            Map<String, List<Map<String, String>>> artistsByType = new TreeMap<>();

            for(ArtistType at : show.getArtistTypes()) {
                String type = at.getType().getType();
                Artist artist = at.getArtist();

                Map<String, String> artistInfo = new LinkedHashMap<>();

                artistInfo.put("firstName", artist.getFirstname());
                artistInfo.put("lastName", artist.getLastname());

                artistsByType.computeIfAbsent(type, k -> new ArrayList<>()).add(artistInfo);
            }

            showMap.put("artistsByType", artistsByType);

            return showMap;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }




    @GetMapping("/shows/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Show show = service.get(id);


        //Récupérer les artistes du spectacle et les grouper par type
        Map<String, ArrayList<Artist>> collaborateurs = new TreeMap<>();

        for(ArtistType at : show.getArtistTypes()) {
            String type = at.getType().getType();

            if(collaborateurs.get(type) == null) {
                collaborateurs.put(type, new ArrayList<>());
            }

            collaborateurs.get(type).add(at.getArtist());
        }

        model.addAttribute("collaborateurs", collaborateurs);

        model.addAttribute("show", show);
        model.addAttribute("title", "Fiche d'un spectacle");

        return "show/show";
    }

}

