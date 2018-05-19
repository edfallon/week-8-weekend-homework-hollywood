package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="directors")

public class Director extends Person {

    private Set<Studio> studios;
    private Set<Film> films;


    public Director() {
    }

    public Director(String name, double money) {
        super(name, money);
        this.films = new HashSet<Film>();
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "studio_director",
            joinColumns = {@JoinColumn(name = "studio_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "director_id", nullable = false, updatable = false)}
    )
    public Set<Studio> getStudios() {
        return studios;
    }

    public void setStudios(Set<Studio> studios) {
        this.studios = studios;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_film",
            joinColumns = {@JoinColumn(name = "person_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
    )
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }


}
