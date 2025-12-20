package be.iccbxl.pid.reservationsspringboot.repository;
<<<<<<< HEAD

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import be.iccbxl.pid.reservationsspringboot.model.Locality;
import org.springframework.data.repository.CrudRepository;

public interface LocalityRepository extends CrudRepository<Locality, Long> {
    Locality findByPostalCode(String postalCode);
<<<<<<< HEAD

    Locality findByLocality(String locality);
}
=======
    Locality findByLocality(String locality);
}


>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
