import db.DBHelper;
import models.Director;
import models.Film;
import models.Genre;
import models.Studio;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Creative Pictures", 10000000);
        DBHelper.save(studio1);

        Director director1 = new Director("Tom", 1000.00);
        DBHelper.save(director1);

        Film film1 = new Film("Finding Nemo", Genre.CHILDREN, director1);
        DBHelper.save(film1);



    }
}
