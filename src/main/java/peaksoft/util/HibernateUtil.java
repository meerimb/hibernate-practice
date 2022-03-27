package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import peaksoft.book.Book;
import peaksoft.car.Car;
import peaksoft.village.Village;
import peaksoft.course.Course;
import peaksoft.instructor.Instructor;
import peaksoft.movie.Movie;
import peaksoft.music.Song;
import peaksoft.singer.Singer;
import peaksoft.sport.Sport;
import peaksoft.student.Student;

import java.util.Properties;

public class HibernateUtil {

private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "meerim");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                properties.put(Environment.SHOW_SQL, true);
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Instructor.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Village.class);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Movie.class);
                configuration.addAnnotatedClass(Sport.class);
                configuration.addAnnotatedClass(Song.class);
                configuration.addAnnotatedClass(Singer.class);
                configuration.addAnnotatedClass(Car.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.getMessage();
            }
        }
        return sessionFactory;
    }
}
