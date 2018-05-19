package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="studios")

public class Studio {

    private int id;
    private String name;
    private double budget;
    private Set<Director> directors;

    public Studio() {
    }

    public Studio(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.directors = new HashSet<Director>();
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

    @Column(name = "budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "studio_director",
            inverseJoinColumns = {@JoinColumn(name = "studio_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name = "director_id", nullable = false, updatable = false)}
    )
    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public void addDirector(Director director){
        this.directors.add(director);
    }
}
