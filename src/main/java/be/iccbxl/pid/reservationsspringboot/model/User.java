package be.iccbxl.pid.reservationsspringboot.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;
    private LocalDateTime created_at;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_representation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "representation_id")
    )
    private List<Representation> representations = new ArrayList<>();

    protected User() {}

    public User(String login, String firstname, String lastname) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.created_at = LocalDateTime.now();
    }

    // Les getters et setters générés par Lombok avec @Data
    // ne sont pas nécessaires si vous gardez l'annotation @Data

    public User addRole(Role role) {
        if(!this.roles.contains(role)) {
            this.roles.add(role);
            role.getUsers().add(this);
        }
        return this;
    }

    public User removeRole(Role role) {
        if(this.roles.contains(role)) {
            this.roles.remove(role);
            role.getUsers().remove(this);
        }
        return this;
    }

    public User addRepresentation(Representation representation) {
        if(!this.representations.contains(representation)) {
            this.representations.add(representation);
            representation.addUser(this);
        }

        return this;
    }

    public User removeRepresentation(Representation representation) {
        if(this.representations.contains(representation)) {
            this.representations.remove(representation);
            representation.getUsers().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
        return login + "(" + firstname + " " + lastname + ")";
    }
}