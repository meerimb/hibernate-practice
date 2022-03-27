package peaksoft.village;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class AppVillage {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Village city=new Village("Nashville",692.5,"english","dollar");
//        create(city);
//        System.out.println(getById(1));
//        read();
//        update(1,"London","pound");
//        delete(1);
//        deleteAll();
    }

    public static int create(Village city){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully"+city);
        return city.getId();
    }
    public static Village getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Village city=session.get(Village.class,id);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public static List<Village>read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Village>cities=session.createQuery("from Village ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded"+cities.size()+cities);
        return cities;
    }

    public static void update(int id,String cityOfName,String language){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Village city=session.get(Village.class,id);
        city.setNameOfCity(cityOfName);
        city.setLanguage(language);
        session.close();
        System.out.println("Successfully updated");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Village city=session.get(Village.class,id);
        session.delete(city);
        session.getTransaction();
        session.close();
        System.out.println("Successfully deleted"+city);
    }
    public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete from Village ");query.executeUpdate();
        session.getTransaction();
        session.close();
        System.out.println("Successfully deleted all data in City");
    }
}
