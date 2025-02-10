package be.iccbxl.pid.reservationsspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.repository.TypeRepository;

@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public List<Type> getAll() {
        List<Type> types = new ArrayList<>();
        repository.findAll().forEach(types::add);
        return types;
    }

    public Type getType(String id) {
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