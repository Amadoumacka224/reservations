package be.iccbxl.pid.reservationsspringboot.repository;

import be.iccbxl.pid.reservationsspringboot.model.Artist;
import org.springframework.data.repository.CrudRepository;

<<<<<<< HEAD
import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
=======
public interface   ArtistRepository extends CrudRepository<Artist, Long> {
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    List<Artist> findByLastname(String lastname);

    Artist findById(long id);
}
