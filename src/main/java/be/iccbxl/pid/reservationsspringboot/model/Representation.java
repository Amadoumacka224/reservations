package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Entity
@Table(name="representations")
public class Representation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="show_id", nullable=false)
    private Show show;

    /**
     * Date de création de la représentation
     */
    private LocalDateTime when;

    /**
     * Lieu de prestation de la représentation
     */
    @ManyToOne
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    public Representation() { }

    public Representation(Show show, LocalDateTime when, Location location) {
        this.show = show;
        this.when = when;
        this.location = location;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Representation [id=" + id + ", show=" + show + ", when=" + when
                + ", location=" + location + "]";
    }

}
