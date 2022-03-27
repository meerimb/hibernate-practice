package peaksoft.instructor;


import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class AppInstructor {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Instructor instructor=new Instructor("Nail","Alishev","Java","Russian");
//     create(instructor);
//        System.out.println(getById(1));
        read();
//        update(1,"Leo","Dicaprio");
//        delete(1);
//        deleteAll();

    }

    public static int create(Instructor instructor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(instructor);
        session.getTransaction().commit();
        session.close();
        System.out.println("Instructor successfully added :" + instructor);
        return instructor.getId();
    }

    public static Instructor getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Instructor instructor= session.get(Instructor.class, id);
        session.getTransaction().commit();
        session.close();
        return instructor;
    }

    public static List<Instructor> read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Instructor>instructors=session.createQuery("From Instructor ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded "+instructors.size()+"students");
        return instructors;
    }

    public static void update(int id,String firstName,String lastName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Instructor instructor=session.get(Instructor.class,id);
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }

    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Instructor instructor=session.get(Instructor.class,id);
        session.delete(instructor);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted"+instructor);
    }

    public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete from Instructor ");query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in instructors");
    }
}
