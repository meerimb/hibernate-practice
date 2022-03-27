package peaksoft.movie;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class AppMovie {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Movie movie=new Movie("Captain America","Joe Saimon","fantastic",1500);
//        create(movie);
//        System.out.println(getById(1));
//        read();
//        update(2,"Terminal","comedy","Stiven Spilberg",2000);
//        delete(1);
//        deleteAll();

    }
    public static int create(Movie movie){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction();
        session.close();
        System.out.println("Successfully created "+movie);
        return movie.getId();
    }
    public static Movie getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie=session.get(Movie.class,id);
        session.getTransaction().commit();
        session.close();
        return movie;
    }
    public static List<Movie>read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Movie>movies=session.createQuery("from Movie ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded "+movies.size()+movies);
        return movies;
    }
    public static void update(int id,String nameOfMovie,String genre,String author,int price){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie=session.get(Movie.class,id);
        movie.setNameOfMovie(nameOfMovie);
        movie.setGenre(genre);
        movie.setAuthor(author);
        movie.setPrice(price);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }

    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie=session.get(Movie.class,id);
        session.delete(movie);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted "+movie);
    }

    public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete from Movie ");query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Movie");
    }
}
