package models;

import java.util.Set;

public class Director extends Person {

    private Set<Studio> studios;

    public Director() {
    }

    public Director(String name, double money) {
        super(name, money);
    }
}
