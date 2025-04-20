package be.iccbxl.pid.reservationsspringboot.api.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
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

@RestController
@RequestMapping("/api")
public class ArtistApiController {

    private final ArtistRepository repository;
    private final ArtistModelAssembler assembler;

    public ArtistApiController(ArtistRepository repository, ArtistModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // GET all artists
    @GetMapping("/artists")
    public CollectionModel<EntityModel<Artist>> all() {
        List<EntityModel<Artist>> artists = ((List<Artist>) repository.findAll()).stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(artists,
                linkTo(methodOn(ArtistApiController.class).all()).withSelfRel());
    }

    // GET a single artist
    @GetMapping("/artists/{id}")
    public EntityModel<Artist> one(@PathVariable Long id) {
        Artist artist = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        return assembler.toModel(artist);
    }

    // POST a new artist
    @PostMapping("/admin/artists")
    public ResponseEntity<?> newArtist(@RequestBody Artist newArtist) {
        Artist savedArtist = repository.save(newArtist);

        return ResponseEntity
                .created(linkTo(methodOn(ArtistApiController.class).one(savedArtist.getId())).toUri())
                .body(assembler.toModel(savedArtist));
    }

    // PUT (update) an artist
    @PutMapping("/admin/artists/{id}")
    public ResponseEntity<?> replaceArtist(@RequestBody Artist newArtist, @PathVariable Long id) {
        Artist updatedArtist = repository.findById(id)
                .map(artist -> {
                    artist.setFirstname(newArtist.getFirstname());
                    artist.setLastname(newArtist.getLastname());
                    return repository.save(artist);
                })
                .orElseGet(() -> {
                    newArtist.setId(id);
                    return repository.save(newArtist);
                });

        return ResponseEntity
                .created(linkTo(methodOn(ArtistApiController.class).one(updatedArtist.getId())).toUri())
                .body(assembler.toModel(updatedArtist));
    }

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
        return ResponseEntity.noContent().build();
    }
}



