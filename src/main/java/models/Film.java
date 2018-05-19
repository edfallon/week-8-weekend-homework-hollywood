package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="films")

public class Film {

    private int id;
    private String name;
    private Genre genre;
    private Set<Actor> actors;
    private Director director;
    private Studio studio;

    public Film() {
    }

    public Film(String name, Genre genre, Director director, Studio studio) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.studio = studio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_film",
            inverseJoinColumns = {@JoinColumn(name = "person_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
    )
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
