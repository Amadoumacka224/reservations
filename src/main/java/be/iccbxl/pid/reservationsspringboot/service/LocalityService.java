package be.iccbxl.pid.reservationsspringboot.service;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import be.iccbxl.pid.reservationsspringboot.model.Locality;
import be.iccbxl.pid.reservationsspringboot.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
@Service
public class LocalityService {
    @Autowired
    private LocalityRepository repository;


    public List<Locality> getAll() {
        List<Locality> localities = new ArrayList<>();

        repository.findAll().forEach(localities::add);

        return localities;
    }

    public Locality get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Locality> locality = repository.findById(indice);

        return locality.isPresent() ? locality.get() : null;
    }

    public void add(Locality locality) {
        repository.save(locality);
    }

    public void update(String id, Locality locality) {
        repository.save(locality);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }
<<<<<<< HEAD

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
}
