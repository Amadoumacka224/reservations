package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localities")

@NoArgsConstructor
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String postalCode;

    @Column(nullable = false, length = 100)
    private String locality;

    @OneToMany(targetEntity = Location.class, mappedBy = "locality")
    private List<Location> locations = new ArrayList<>();

    public Locality(String postalCode, String locality) {
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public Locality addLocation(Location location) {
        if (!this.locations.contains(location)) {
            this.locations.add(location);
            location.setLocality(this);
        }
        return this;
    }

    public Locality removeLocation(Location location) {
        if (this.locations.contains(location)) {
            this.locations.remove(location);
            if (location.getLocality().equals(this)) {
                location.setLocality(null);
            }
        }
        return this;
    }
    @Override
    public String toString() {
        return "Locality [id=" + id + ", postalCode=" + postalCode + ", locality=" + locality + "]";
    }
}
