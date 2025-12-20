package be.iccbxl.pid.reservationsspringboot.model;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="types")
public class Type {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    private Long id;
    private String type;

    @ManyToMany
    @JoinTable(
            name = "artist_type",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> artists = new ArrayList<>();

<<<<<<< HEAD
=======
    public Type() {
    }

    public Type(Long id, String type) {
        super();
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    public List<Artist> getArtists() {
        return artists;
    }

    public Type addArtist(Artist artist) {
<<<<<<< HEAD
        if (!this.artists.contains(artist)) {
=======
        if(!this.artists.contains(artist)) {
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
            this.artists.add(artist);
            artist.addType(this);
        }

        return this;
    }

    public Type removeType(Artist artist) {
<<<<<<< HEAD
        if (this.artists.contains(artist)) {
=======
        if(this.artists.contains(artist)) {
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
            this.artists.remove(artist);
            artist.getTypes().remove(this);
        }

        return this;
    }

<<<<<<< HEAD
}
=======
    @Override
    public String toString() {
        return "Type [id=" + id + ", type=" + type + "]";
    }


}


>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
