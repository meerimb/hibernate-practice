package peaksoft.book;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class AppBook {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Book book=new Book("Becoming","M.Obama","Memuar",1000,"english");
        create(book);
//        System.out.println(getById(1));
//        read();
//        update(1,"Master i Margarita","roman",2000,"M.Bulgakov");
//        delete(1);
//        deleteAll();



    }
    public static int create(Book book){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        System.out.println("Successfully created");
        session.close();
        return book.getId();
    }

    public static Book getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Book book=session.get(Book.class,id);
        session.getTransaction().commit();
        session.close();
        return book;
    }
public static List<Book>read(){
   Session session=HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();
    List<Book>books=session.createQuery("from Book ").getResultList();
    session.getTransaction().commit();
    session.close();
    System.out.println("Finded "+books.size()+books);
    return books;
}
public static void update(int id,String nameOfBook,String genre,int price,String author){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Book book=session.get(Book.class,id);
        book.setNameOfBook(nameOfBook);
        book.setGenre(genre);
        book.setPrice(price);
        book.setAuthor(author);
        session.getTransaction();
        session.close();
    System.out.println("Successfully updated");
}
public static void delete(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Book book=session.get(Book.class,id);
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    System.out.println("Successfully deleted"+book);
}
public static void deleteAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    Query query=session.createQuery("DELETE from Book ");query.executeUpdate();
    session.getTransaction().commit();
    session.close();
    System.out.println("Successfully deleted all datas in book");
}
}
