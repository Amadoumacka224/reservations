package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String slug;

    private String title;

    private String description;

    @Column(name="poster_url")
    private String posterUrl;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    private boolean bookable;

    private double price;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Getter
    @OneToMany(targetEntity=Representation.class, mappedBy="show")
    private List<Representation> representations = new ArrayList<>();

    public Show() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Show addRepresentation(Representation representation) {
        if(!this.representations.contains(representation)) {
            this.representations.add(representation);
            representation.setShow(this);
        }
        return this;
    }

    public Show removeRepresentation(Representation representation) {
        if(this.representations.contains(representation)) {
            this.representations.remove(representation);
            if(representation.getShow().equals(this)) {
                representation.setShow(null);
            }
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show)) return false;
        Show show = (Show) o;
        return Objects.equals(slug, show.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug);
    }

    @Override
    public String toString() {
        return "Show [id=" + id + ", slug=" + slug + ", title=" + title
                + ", description=" + description + ", posterUrl=" + posterUrl + ", location="
                + location + ", bookable=" + bookable + ", price=" + price
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", representations=" + representations.size() + "]";
    }
}