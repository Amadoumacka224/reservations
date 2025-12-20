package be.iccbxl.pid.reservationsspringboot.model;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@Table(name = "representations")
public class Representation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name="representations")
public class Representation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="show_id", nullable=false)
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    private Show show;

    /**
     * Date de création de la représentation
     */
<<<<<<< HEAD
    @Column(name = "scheduled_at", nullable = false)
    private LocalDateTime scheduledAt;
=======
    private LocalDateTime when;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

    /**
     * Lieu de prestation de la représentation
     */
    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "location_id", nullable = true)
    private Location location;

    /**
     * Jauge mise en vente (peut être null → on tombera sur location.capacity)
     */
    @Column(nullable = false)
    private Integer capacity;

    /**
     * Réservations de cette représentation, avec quantité et prix
     */
    @OneToMany(mappedBy = "representation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<RepresentationReservation> items = new ArrayList<>();

    public Representation() {
    }

    public Representation(Show show, LocalDateTime scheduledAt, Location location, Integer capacity, List<RepresentationReservation> items) {
        this.show = show;
        this.scheduledAt = scheduledAt;
        this.location = location;
        this.capacity = capacity;
        this.items = items;
    }

    public void setItems(List<RepresentationReservation> items) {
        this.items = items;
    }


    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
=======
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    /**
     * Liste des utilisateurs ayant réservé cette représentation
     */
    //@JsonIgnore
    @ManyToMany(mappedBy = "representations")
    private List<User> users = new ArrayList<>();

    public Representation() { }

    public Representation(Show show, LocalDateTime when, Location location) {
        this.show = show;
        this.when = when;
        this.location = location;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    }

    public void setShow(Show show) {
        this.show = show;
    }

<<<<<<< HEAD
    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
=======
    public void setWhen(LocalDateTime when) {
        this.when = when;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    }

    public void setLocation(Location location) {
        this.location = location;
    }

<<<<<<< HEAD
    /**
     * Retourne la liste des utilisateurs ayant réservé
     */
    @Transient
    public List<User> getUsers() {
        return items.stream()
                .map(RepresentationReservation::getReservation)
                .map(Reservation::getUser)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Capacité effective : soit la capacité propre, soit celle du lieu
     */
    @Transient
    public int getEffectiveCapacity() {
        if (capacity != null) return capacity;
        return (location != null ? location.getCapacity() : 0);
    }

    /**
     * Somme des quantités déjà réservées
     */
    @Transient
    public int getBookedSeats() {
        return items.stream()
                .mapToInt(RepresentationReservation::getQuantity)
                .sum();
    }

    /**
     * Places restantes
     */
    @Transient
    public int getAvailableSeats() {
        return getEffectiveCapacity() - getBookedSeats();
=======
    public List<User> getUsers() {
        return users;
    }

    public Representation addUser(User user) {
        if(!this.users.contains(user)) {
            this.users.add(user);
            user.addRepresentation(this);
        }

        return this;
    }

    public Representation removeUser(User user) {
        if(this.users.contains(user)) {
            this.users.remove(user);
            user.getRepresentations().remove(this);
        }

        return this;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Representation{" +
                "id=" + id +
                ", show=" + show +
                ", scheduledAt=" + scheduledAt +
                ", location=" + location +
                '}';
    }

=======
        return "Representation [id=" + id + ", show=" + show + ", when=" + when
                + ", location=" + location + "]";
    }
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
}