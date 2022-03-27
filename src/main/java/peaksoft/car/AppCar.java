package peaksoft.car;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class AppCar {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Car car=new Car("Tesla","black",2022,10000);
//        create(car);
//        System.out.println(getById(1));
//        read();
//        update(1,"Bentley","blue");
//        delete(1);
//        deleteAll();

    }


    public static int create(Car car){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created "+car);
        return car.getId();
    }

    public static Car getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car=session.get(Car.class,id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    public static List<Car>read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Car>cars=session.createQuery("from Car ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded "+cars.size()+cars);
        return cars;

    }

    public static void update(int id,String brand, String color){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car=session.get(Car.class,id);
        car.setBrand(brand);
        car.setColor(color);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated"+car);
    }

    public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car=session.get(Car.class,id);
        session.delete(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted"+car);
    }

    public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete  from Car ");query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Car");
    }
}
