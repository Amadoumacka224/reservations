package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
=======
@Getter
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    private String role;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }


    public Role addUser(User user) {
        if (!this.users.contains(user)) {
=======

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
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
            this.users.add(user);
            user.addRole(this);
        }

        return this;
    }

    public Role removeUser(User user) {
<<<<<<< HEAD
        if (this.users.contains(user)) {
=======
        if(this.users.contains(user)) {
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
            this.users.remove(user);
            user.getRoles().remove(this);
        }

        return this;
    }
<<<<<<< HEAD
}
=======

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + "]";
    }
}
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
