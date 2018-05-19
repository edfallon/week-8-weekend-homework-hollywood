import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Creative Pictures", 1000000.00);
        DBHelper.save(studio1);

        Studio studio2 = new Studio("Film House", 2000000.00);
        DBHelper.save(studio2);

        Director director1 = new Director("Tom", 1000.00);
        DBHelper.save(director1);

        Director director2 = new Director("Jenny", 3000.00);
        DBHelper.save(director2);

        Actor actor1 = new Actor("Harry", 10000.00);
        DBHelper.save(actor1);

        Actor actor2 = new Actor("Emma", 50000.00);
        DBHelper.save(actor2);

        Film film1 = new Film("Finding Nemo", Genre.ANIMATED, director1);
        DBHelper.save(film1);

        Film film2 = new Film("Captain Philips", Genre.THRILLER, director2);
        DBHelper.save(film2);

        List<Person> people = DBHelper.getAll(Person.class);



    }
}
