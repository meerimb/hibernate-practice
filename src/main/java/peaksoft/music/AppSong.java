package peaksoft.music;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class AppSong {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
      Song song=new Song("Classic","Mozart","english",LocalDate.of(1970,01,02));
//    create(song);
//        System.out.println(getById(1));
//        update(1,"Hip-Hop","Jay Z",LocalDate.of(1990,01,03));
//        read();
//        delete(1);
//        deleteAll();


    }

    private static int create(Song song){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(song);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created"+ song);
        return song.getId();
    }

    private static Song getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Song song=session.get(Song.class,id);
        session.getTransaction().commit();
        session.close();
        return song;
    }

    private static void update(int id, String genre, String author, LocalDate realiseDate){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Song song=session.get(Song.class,id);
        song.setGenre(genre);
        song.setAuthor(author);
        song.setRealiseDate(realiseDate);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated"+song);

    }

    public static List<Song>read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Song>songs=session.createQuery("from Song ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded "+songs.size()+songs);
        return songs;
    }

    private static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Song song=session.get(Song.class,id);
        session.delete(song);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted "+song);
    }

    private static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete from Song ");query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Song");
    }
}
