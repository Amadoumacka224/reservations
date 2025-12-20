package be.iccbxl.pid.reservationsspringboot.service;

<<<<<<< HEAD
import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.repository.TypeRepository;

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public List<Type> getAll() {
        List<Type> types = new ArrayList<>();
<<<<<<< HEAD

        repository.findAll().forEach(types::add);

=======
        repository.findAll().forEach(types::add);
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
        return types;
    }

    public Type getType(String id) {
<<<<<<< HEAD
        Long indice = (long) Integer.parseInt(id);

        Optional<Type> type = repository.findById(indice);

        return type.isPresent() ? type.get() : null;
    }

    public void addType(Type type) {
        repository.save(type);
    }

    public void updateType(String id, Type type) {
        repository.save(type);
    }

    public void deleteType(String id) {
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }

}
=======
        try {
            Long indice = Long.parseLong(id);
            Optional<Type> type = repository.findById(indice);
            return type.orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Type addType(Type type) {
        return repository.save(type);
    }

    public Type updateType(String id, Type type) {
        try {
            Long indice = Long.parseLong(id);
            if (repository.existsById(indice)) {
                type.setId(indice);
                return repository.save(type);
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean deleteType(String id) {
        try {
            Long indice = Long.parseLong(id);
            if (repository.existsById(indice)) {
                repository.deleteById(indice);
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Type get(Long id) {
        return null;
    }
}
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
