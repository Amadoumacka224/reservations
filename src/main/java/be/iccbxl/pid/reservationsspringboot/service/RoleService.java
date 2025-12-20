package be.iccbxl.pid.reservationsspringboot.service;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import be.iccbxl.pid.reservationsspringboot.model.Role;
import be.iccbxl.pid.reservationsspringboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;


    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();

        repository.findAll().forEach(roles::add);

        return roles;
    }

    public Role get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Role> role = repository.findById(indice);

        return role.isPresent() ? role.get() : null;
    }

    public void add(Role role) {
        repository.save(role);
    }

    public void update(String id, Role role) {
        repository.save(role);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }
<<<<<<< HEAD

}
=======
}

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
