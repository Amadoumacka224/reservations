package be.iccbxl.pid.reservationsspringboot.controller;


import be.iccbxl.pid.reservationsspringboot.model.Representation;
import be.iccbxl.pid.reservationsspringboot.service.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class RepresentationController {
    @Autowired
    RepresentationService service;

    @GetMapping("/representations")
    public String index(Model model) {
        List<Representation> representations = service.getAll();

        model.addAttribute("representations", representations);
        model.addAttribute("title", "Liste des representations");

        return "representation/index";
    }

    // task at the intership

    @GetMapping("/json/representations")
    public ResponseEntity<List<Map<String, Object>>> getAllRepresentationsAsJson() {
        List<Representation> representations = service.getAll();

        List<Map<String, Object>> result = representations.stream().map(representation -> {
            Map<String, Object> representationMap = new LinkedHashMap<>();

            // Ajout des propriétés de base
            representationMap.put("id", representation.getId());
            representationMap.put("date", representation.getWhen().toLocalDate());
            representationMap.put("heure", representation.getWhen().toLocalTime());

            // Gestion de la relation avec le spectacle
            if(representation.getShow() != null) {
                Map<String, Object> showMap = new LinkedHashMap<>();
                showMap.put("id", representation.getShow().getId());
                showMap.put("titre", representation.getShow().getTitle());
                representationMap.put("spectacle", showMap);
            }

            // Gestion de la relation avec le lieu
            if(representation.getLocation() != null) {
                Map<String, Object> locationMap = new LinkedHashMap<>();
                locationMap.put("id", representation.getLocation().getId());
                locationMap.put("nom", representation.getLocation().getDesignation());
                representationMap.put("lieu", locationMap);
            }

            return representationMap;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }







    @GetMapping("/representations/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Representation representation = service.get(id);
        model.addAttribute("representation", representation);
        model.addAttribute("date", representation.getWhen().toLocalDate());
        model.addAttribute("heure", representation.getWhen().toLocalTime());
        model.addAttribute("title", "Fiche d'une representation");

        return "representation/show";
    }

}
