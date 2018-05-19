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
        this.studios = new HashSet<Studio>();
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

    @OneToMany(mappedBy = "director")
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }


}
