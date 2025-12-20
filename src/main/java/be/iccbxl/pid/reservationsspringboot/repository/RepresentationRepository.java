package be.iccbxl.pid.reservationsspringboot.repository;

import be.iccbxl.pid.reservationsspringboot.model.Location;
import be.iccbxl.pid.reservationsspringboot.model.Representation;
import be.iccbxl.pid.reservationsspringboot.model.Show;
import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import java.time.LocalDateTime;
import java.util.List;

public interface RepresentationRepository extends CrudRepository<Representation, Long> {
    List<Representation> findByShow(Show show);
<<<<<<< HEAD

    List<Representation> findByLocation(Location location);

    List<Representation> findByScheduledAt(LocalDateTime scheduledAt);

=======
    List<Representation> findByLocation(Location location);
    List<Representation> findByWhen(LocalDateTime when);
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
}
