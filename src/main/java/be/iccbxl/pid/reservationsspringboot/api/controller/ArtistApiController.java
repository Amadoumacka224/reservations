package be.iccbxl.pid.reservationsspringboot.api.controller;

import be.iccbxl.pid.reservationsspringboot.dto.ArtistDTO;
import be.iccbxl.pid.reservationsspringboot.dto.ArtistTypeDTO;
import be.iccbxl.pid.reservationsspringboot.mapper.ArtistMapper;
import be.iccbxl.pid.reservationsspringboot.model.Artist;
import be.iccbxl.pid.reservationsspringboot.service.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
import java.util.Map;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.iccbxl.pid.reservationsspringboot.api.hateoas.ArtistModelAssembler;
import be.iccbxl.pid.reservationsspringboot.model.Artist;
import be.iccbxl.pid.reservationsspringboot.repository.ArtistRepository;
import org.springframework.web.client.RestTemplate;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

@RestController
@RequestMapping("/api")

public class ArtistApiController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private ArtistMapper artistMapper;
       // GET /api/artists
    @GetMapping("/artists")
    public List<ArtistDTO> listAll() {
        return artistService.getAllArtists().stream()
                .map(artistMapper::toDTO)
                .collect(Collectors.toList());
    }

    // GET /api/artists/{id}
    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistTypeDTO> getById(@PathVariable Long id) {
        Artist a = artistService.getArtist(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artistMapper.toArtistTypeDTO(a));
    }

    @PostMapping ("/artists")
    public ResponseEntity<ArtistDTO> create(@Valid @RequestBody ArtistDTO artistDTO) {
        Artist a = artistMapper.toEntity(artistDTO);
        artistService.addArtist(a);
        return ResponseEntity.ok(artistMapper.toDTO(a));

    }

    @PutMapping("/artists/{id}")
    public ResponseEntity<ArtistDTO> update(@Valid @PathVariable Long id, @RequestBody ArtistDTO artistDTO ) {
        Artist existing = artistService.getArtist(id);
        if (existing == null) return ResponseEntity.notFound().build();

        existing.setFirstname( artistDTO.getFirstname() );
        existing.setLastname( artistDTO.getLastname() );
        artistService.updateArtist( id, existing );

        return ResponseEntity.ok(artistMapper.toDTO(existing));
    }
    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Artist existing = artistService.getArtist(id);
        if (existing == null) return ResponseEntity.notFound().build();

<<<<<<< HEAD
        artistService.deleteArtist(id);
=======
    // Vérification du statut de l'API
    @GetMapping("/github")
    public ResponseEntity<?> getApiStatus() {
        String repoOwner = "Amadoumacka224";
        String repoName = "reservations";
        String issuesUrl = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/issues";
        String repoUrl = "https://api.github.com/repos/" + repoOwner + "/" + repoName;
        String userUrl = "https://api.github.com/users/" + repoOwner;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github.v3+json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Récupérer les issues (tâches) du dépôt
        ResponseEntity<List> issuesResponse = restTemplate.exchange(issuesUrl, HttpMethod.GET, entity, List.class);

        // Récupérer les infos du dépôt
        ResponseEntity<Map> repoResponse = restTemplate.exchange(repoUrl, HttpMethod.GET, entity, Map.class);

        // Récupérer les infos de l'utilisateur
        ResponseEntity<Map> userResponse = restTemplate.exchange(userUrl, HttpMethod.GET, entity, Map.class);

        return ResponseEntity.ok(
                new Object() {
                    public final String github_url = "https://github.com/" + repoOwner + "/" + repoName;
                    public final Map<String, Object> repository = repoResponse.getBody(); // Infos du dépôt
                    public final Map<String, Object> user = userResponse.getBody(); // Infos de l'utilisateur
                    public final List<Map<String, Object>> issues = issuesResponse.getBody(); // Issues
                }
        );
    }

    @GetMapping("/datetime")
    public ResponseEntity<Map<String, String>> getCurrentUtcDateTime() {
        // Format ISO-8601 complet avec le décalage UTC
        String utcDateTime = Instant.now().atOffset(ZoneOffset.UTC)
                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        // Construction de la réponse
        Map<String, String> response = new HashMap<>();
        response.put("message", "Current UTC date and time");
        response.put("utc_datetime", utcDateTime);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(response);
    }


    // DELETE an artist
    @DeleteMapping("/admin/artists/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable Long id) {
        repository.deleteById(id);
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
        return ResponseEntity.noContent().build();

<<<<<<< HEAD
    }


}
=======


>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
