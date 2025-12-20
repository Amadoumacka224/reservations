package be.iccbxl.pid.reservationsspringboot.repository;

<<<<<<< HEAD
import be.iccbxl.pid.reservationsspringboot.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByDesignation(String designation);

    Optional<Location> findById(Long id);

=======
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import be.iccbxl.pid.reservationsspringboot.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByDesignation(String designation);
    Optional<Location> findById(Long id);
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
}
