package models;

import java.util.Set;

public class Film {

    private int id;
    private String name;
    private Genre genre;
    private Set<Actor> actors;
    private Director director;

    public Film() {
    }

    public Film(String name, Genre genre, Director director) {
        this.name = name;
        this.genre = genre;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
