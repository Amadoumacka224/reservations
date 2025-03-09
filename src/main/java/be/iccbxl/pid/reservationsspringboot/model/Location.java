package be.iccbxl.pid.reservationsspringboot.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String slug;

    private String designation;
    private String address;

    @ManyToOne
    @JoinColumn(name = "locality_id", nullable = false)
    private Locality locality;

    private String website;
    private String phone;

    @OneToMany(targetEntity = Show.class, mappedBy = "location")
    private List<Show> shows = new ArrayList<>();

    @Getter
    @OneToMany(targetEntity = Representation.class, mappedBy = "location")
    private List<Representation> representations = new ArrayList<>();

    public Location addRepresentation(Representation representation) {
        if (!this.representations.contains(representation)) {
            this.representations.add(representation);
            representation.setLocation(this);
        }

        return this;
    }

    public Location removeRepresentation(Representation representation) {
        if (this.representations.contains(representation)) {
            this.representations.remove(representation);
            if (representation.getLocation().equals(this)) {
                representation.setLocation(null);
            }
        }

        return this;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", slug=" + slug + ", designation=" + designation
                + ", address=" + address + ", locality=" + locality + ", website="
                + website + ", phone=" + phone + ", shows=" + shows.size()
                + ", representations=" + representations.size() + "]";
    }


}
