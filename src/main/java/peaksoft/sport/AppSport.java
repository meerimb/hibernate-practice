package peaksoft.sport;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class AppSport {
    public static void main(String[] args) {

        HibernateUtil.getSessionFactory();
        Sport sport=new Sport("Football","Monday", LocalDate.of(2022,01,01),2000);
//        create(sport);
//        read();
//        update(2,"Volleyball",LocalDate.of(2022,01,15),2500,"Sunday");
//        delete(2);
//        deleteAll();

    }
    private static int create(Sport sport){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(sport);
        session.getTransaction().commit();
        System.out.println("Successfully created "+sport);
        session.close();
        return sport.getId();
    }

    public static Sport getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sport sport=session.get(Sport.class,id);
        session.getTransaction().commit();
        session.close();
        return sport;
    }

    public static List<Sport>read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Sport>sports=session.createQuery("from Sport ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded "+sports.size()+sports);
        return sports;
    }

    public static void update(int id, String kindOfSport, LocalDate startTime, int price,String trainingDay){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sport sport=session.get(Sport.class,id);
        sport.setKindOfSport(kindOfSport);
        sport.setStartTime(startTime);
        sport.setPrice(price);
        sport.setTrainingDay(trainingDay);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }

    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sport sport=session.get(Sport.class,id);
        session.delete(sport);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted "+sport);
    }

    public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete from Sport ");query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all data from Sports");
    }
}
