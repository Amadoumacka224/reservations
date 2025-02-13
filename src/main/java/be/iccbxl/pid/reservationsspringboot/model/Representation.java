package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="representations")
public class Representation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    private Integer PlaceAvailable;

    /**
     * Date de la représentation
     */
    private LocalDateTime representationDate;

    /**
     * Lieu de prestation de la représentation
     */
    @ManyToOne
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    @ManyToMany
    @JoinTable(
            name = "representations_users",
            joinColumns = @JoinColumn(name = "representation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    public Representation() { }


}
