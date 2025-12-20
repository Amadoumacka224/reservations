package be.iccbxl.pid.reservationsspringboot.service;

<<<<<<< HEAD
import be.iccbxl.pid.reservationsspringboot.model.Location;
=======
import be.iccbxl.pid.reservationsspringboot.model.Location; // Assurez-vous que l'importation est correcte
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import be.iccbxl.pid.reservationsspringboot.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;

<<<<<<< HEAD

    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();

        repository.findAll().forEach(locations::add);

=======
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        repository.findAll().forEach(locations::add);
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
        return locations;
    }

    public Location get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Location> location = repository.findById(indice);
<<<<<<< HEAD

        return location.isPresent() ? location.get() : null;
=======
        return location.orElse(null);
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    }

    public void add(Location location) {
        repository.save(location);
    }

    public void update(String id, Location location) {
        repository.save(location);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
<<<<<<< HEAD

        repository.deleteById(indice);
    }

=======
        repository.deleteById(indice);
    }
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
}
