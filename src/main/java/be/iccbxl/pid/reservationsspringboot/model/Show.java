package be.iccbxl.pid.reservationsspringboot.model;

import com.github.slugify.Slugify;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToMany(targetEntity=Representation.class, mappedBy="show")
    private List<Representation> representations = new ArrayList<>();
    private String slug;

    private String title;

    private String description;
    /**
     * Lieu de création du spectacle
     */
    @ManyToOne
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    private String posterUrl;

    private boolean bookable;

    private double price;

    private String stripeProductId;

    /**
     * Date de création du spectacle
     */
    @Column(name="created_at")
    private LocalDateTime createdAt;

    /**
     * Date de modification du spectacle
     */
    @Column(name="updated_at")
    private LocalDateTime updatedAt;




    public Show(String slug, String title, String description, Location location, String posterUrl, boolean bookable, double price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        Slugify slg = new Slugify();
        this.slug = slg.slugify(title);
        this.title = title;
        this.description = description;
        this.location = location;
        this.posterUrl = posterUrl;
        this.bookable = bookable;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Show() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRepresentations(List<Representation> representations) {
        this.representations = representations;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStripeProductId(String stripe_product_id) {
        this.stripeProductId = stripe_product_id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                ", posterUrl='" + posterUrl + '\'' +
                ", bookable=" + bookable +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


    public void addArtistType(ArtistType artistType) {
    }

    public <E> List<E> getArtistTypes() {
        return List.of();
    }
}
