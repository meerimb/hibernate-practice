package peaksoft.singer;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class AppSinger {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Singer singer=new Singer("Mot","rap",32,"Russia");
//        create(singer);
        System.out.println(getById(1));
        read();
//        update(1,"Basta",38);
//        delete(1);
//        deleteAll();
    }

    public static int create(Singer singer){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(singer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated"+singer);
        return singer.getId();
    }

    private static Singer getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Singer singer=session.get(Singer.class,id);
        session.getTransaction().commit();
        session.close();
        return singer;
    }

    public static List<Singer>read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Singer>singers=session.createQuery("from Singer ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded "+singers.size()+singers);
        return singers;
    }

    public static void update(int id, String nickNameOfSinger, int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Singer singer=session.get(Singer.class,id);
        singer.setNickNameOfSinger(nickNameOfSinger);
        singer.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated "+singer);

    }

    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Singer singer=session.get(Singer.class,id);
        session.delete(singer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted "+singer);
    }

    public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete from Singer ");query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Singer");
    }
}
