package be.iccbxl.pid.reservationsspringboot.service;

import be.iccbxl.pid.reservationsspringboot.model.User;
import be.iccbxl.pid.reservationsspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Transactional(readOnly = true)
    public User getUser(String id) {
        return repository.findById(Long.parseLong(id));
    }

    @Transactional
    public void addUser(User user) {
        repository.save(user);
    }

    @Transactional
    public void updateUser(String id, User user) {
        repository.save(user);
    }

    @Transactional
    public void deleteUser(String id) {
        repository.deleteById(Long.parseLong(id));
    }
}
