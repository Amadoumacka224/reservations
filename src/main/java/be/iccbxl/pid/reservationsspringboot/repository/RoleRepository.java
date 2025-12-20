package be.iccbxl.pid.reservationsspringboot.repository;

import be.iccbxl.pid.reservationsspringboot.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
<<<<<<< HEAD
=======

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
