package be.iccbxl.pid.reservationsspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
=======

import jakarta.persistence.*;
import lombok.Data;

@Data
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;
<<<<<<< HEAD

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime created_at;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Role> roles = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    /**
     * Toutes les réservations passées par cet utilisateur.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();

    /**
     * Retourne la liste des spectacles (Representation) réservés par cet utilisateur,
     * en parcourant toutes ses Reservation → RepresentationReservation.
     */
    @Transient
    public List<Representation> getRepresentations() {
        return reservations.stream()
                .flatMap(res -> res.getItems().stream())
                .map(item -> item.getRepresentation())
                .distinct()
                .collect(Collectors.toList());
    }

    //pour commentaires
    public boolean hasRole(UserRole role) {
        return this.role == role;
    }


    // Méthode utilitaire pour lier une nouvelle réservation
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        reservation.setUser(this);
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }


    @Override
    public String toString() {
        return "login{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                '}';
=======
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
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    }
}