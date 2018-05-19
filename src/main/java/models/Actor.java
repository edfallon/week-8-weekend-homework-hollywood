package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actors")

public class Actor extends Person{

    private Set<Film> films;

    public Actor() {
    }

    public Actor(String name, double money) {
        super(name, money);
        this.films = new HashSet<Film>();
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "actor_film",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
    )
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
