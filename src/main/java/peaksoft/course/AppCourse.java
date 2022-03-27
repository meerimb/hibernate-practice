package peaksoft.course;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class AppCourse {
    public static void main(String[] args) {

        HibernateUtil.getSessionFactory();
        Course course=new Course("Java", LocalDate.of(2021,10,01),"Kyrgyz",10);
        create(course);



    }

    public static int create (Course course){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction();
        session.close();
        System.out.println("Added succesfully"+ course);
        return course.getId();
    }

    public static Course getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Course course=session.get(Course.class,id);
        session.getTransaction().commit();
        session.close();
        return course;

    }

    public static List<Course>read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Course>courses=session.createQuery("from Course ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded"+ courses.size()+courses);
        return courses;
    }
    public static void update(int id,String courseName,String language){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Course course=session.get(Course.class,id);
        course.setCourseName(courseName);
        course.setLanguage(language);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Course course=session.get(Course.class,id);
        session.delete(course);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted"+ course);
    }
    public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("delete from Course ");query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Courses");
    }

}
