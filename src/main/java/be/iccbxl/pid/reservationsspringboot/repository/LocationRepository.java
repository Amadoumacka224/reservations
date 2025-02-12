package be.iccbxl.pid.reservationsspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import javax.xml.stream.Location;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByDesignation(String designation);
    Optional<Location> findById(Long id);
}
