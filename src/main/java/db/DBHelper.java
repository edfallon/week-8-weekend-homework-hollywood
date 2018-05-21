package db;

import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBHelper {

    private static Session session;
    private static Transaction transaction;

    public static void save(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();

        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T>  getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static <T> T find(Class classType, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (T)cr.uniqueResult();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void addDirectorToStudio(Studio studio, Director director){
        studio.addDirector(director);
        director.addStudio(studio);
        save(studio);
    }

    public static void addFilmToStudio(Studio studio, Film film){
        studio.addFilm(film);
        save(studio);
    }

    public static void addActorToFilm(Film film, Actor actor){
        film.addActor(actor);
        actor.addFilm(film);
        save(film);
    }

    public Set<Film> findAllFilmsByGenre(Actor actor, Genre genre){
        Set<Film> copyOfFilms = actor.getFilms();
        Set<Film> filmsWithSelectedGenre = new HashSet<Film>();
        for (Film film : copyOfFilms){
            if (film.getGenre() == genre){
                filmsWithSelectedGenre.add(film);
            }
            else{
                return null;
            }
        }
        return filmsWithSelectedGenre;

    }


}
