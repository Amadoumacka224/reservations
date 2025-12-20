package be.iccbxl.pid.reservationsspringboot.repository;

<<<<<<< HEAD
import be.iccbxl.pid.reservationsspringboot.model.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
=======
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import be.iccbxl.pid.reservationsspringboot.model.Type;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

public interface TypeRepository extends CrudRepository<Type, Long> {
    Type findByType(String type);

<<<<<<< HEAD
    Optional<Type> findById(Long id);
}
=======
}
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
