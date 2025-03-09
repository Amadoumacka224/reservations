package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    // Constructeur par défaut nécessaire pour JPA
    protected Role() {}

    public Role(String role) {
        this.role = role;
    }

    public Role addUser(User user) {
        if(!this.users.contains(user)) {
            this.users.add(user);
            user.addRole(this);
        }

        return this;
    }

    public Role removeUser(User user) {
        if(this.users.contains(user)) {
            this.users.remove(user);
            user.getRoles().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + "]";
    }
}