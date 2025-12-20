package be.iccbxl.pid.reservationsspringboot.model;

<<<<<<< HEAD
=======

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
<<<<<<< HEAD
@Table(name = "artist_type")
public class ArtistType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToMany(targetEntity = Show.class)
=======
@Table(name="artist_type")
public class ArtistType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="artist_id", nullable=false)
    private Artist artist;

    @ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    private Type type;

    @ManyToMany(targetEntity=Show.class)
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    @JoinTable(
            name = "artist_type_show",
            joinColumns = @JoinColumn(name = "artist_type_id"),
            inverseJoinColumns = @JoinColumn(name = "show_id"))
    private List<Show> shows = new ArrayList<>();

<<<<<<< HEAD
    public ArtistType() {
    }
=======
    protected ArtistType() { }
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

    public ArtistType(Artist artist, Type type, List<Show> shows) {
        this.artist = artist;
        this.type = type;
        this.shows = shows;
    }

    public Long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Show> getShows() {
        return shows;
    }

    public ArtistType addShow(Show show) {
<<<<<<< HEAD
        if (!this.shows.contains(show)) {
=======
        if(!this.shows.contains(show)) {
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
            this.shows.add(show);
            show.addArtistType(this);
        }

        return this;
    }

    public ArtistType removeShow(Show show) {
<<<<<<< HEAD
        if (this.shows.contains(show)) {
=======
        if(this.shows.contains(show)) {
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
            this.shows.remove(show);
            show.getArtistTypes().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return artist.getFirstname() + " " + artist.getLastname() + " (" + type.getType() + ")";
    }

}
=======
        return "ArtistType [id=" + id + ", artist=" + artist + ", type=" + type
                + ", shows=" + shows + "]";
    }

}


>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
