package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
<<<<<<< HEAD

=======
import lombok.NoArgsConstructor;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localities")
<<<<<<< HEAD
=======

@NoArgsConstructor
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    private String postalCode;
    private String locality;

    // @OneToMany(targetEntity = Locality.class, mappedBy = "locality")
    @OneToMany(mappedBy = "locality")
    private List<Location> locations = new ArrayList<>();

    protected Locality() {
    }

=======

    @Column(nullable = false, length = 10)
    private String postalCode;

    @Column(nullable = false, length = 100)
    private String locality;

    @OneToMany(targetEntity = Location.class, mappedBy = "locality")
    private List<Location> locations = new ArrayList<>();

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    public Locality(String postalCode, String locality) {
        this.postalCode = postalCode;
        this.locality = locality;
    }

<<<<<<< HEAD
    public Long getId() {
        return id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public List<Location> getLocations() {
        return locations;
    }

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    public Locality addLocation(Location location) {
        if (!this.locations.contains(location)) {
            this.locations.add(location);
            location.setLocality(this);
        }
<<<<<<< HEAD

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
        return this;
    }

    public Locality removeLocation(Location location) {
        if (this.locations.contains(location)) {
            this.locations.remove(location);
            if (location.getLocality().equals(this)) {
                location.setLocality(null);
            }
        }
<<<<<<< HEAD

        return this;
    }

=======
        return this;
    }
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    @Override
    public String toString() {
        return "Locality [id=" + id + ", postalCode=" + postalCode + ", locality=" + locality + "]";
    }
<<<<<<< HEAD

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
}
