package be.iccbxl.pid.reservationsspringboot.repository;

import be.iccbxl.pid.reservationsspringboot.model.Show;
import be.iccbxl.pid.reservationsspringboot.model.Location;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
    Optional<Show> findBySlug(String slug);
    Optional<Show> findByTitle(String title);
    List<Show> findByLocation(Location location);
}