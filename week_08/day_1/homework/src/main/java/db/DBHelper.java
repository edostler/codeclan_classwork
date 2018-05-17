package db;

import models.Book;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(String className) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from " + className;
            results = session.createQuery(hql).list();
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void deleteAll(String className) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "delete from " + className;
            Query query = session.createQuery(hql);
            query.executeUpdate();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Book> getBooksByAuthorId(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Book WHERE author_id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            books = query.list();
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return books;
    }

//    public static Book getBookById(int id) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Book book = null;
//        try {
//            transaction = session.beginTransaction();
//            book = (Book) session.get(Book.class, id);
//        }
//        catch (HibernateException ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return book;
//    }
//
////    we don't want to do it this way becasue it will bring back a list of 1, rather than a single item'
//    public static <T> List<T> getGenericById_list(int id, String className) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<T> result = null;
//        try {
//            transaction = session.beginTransaction();
//            String hql = "from " + className + " where id = :id";
//            Query query =  session.createQuery(hql);
//            query.setInteger("id", id);
//            result = query.list();
//            transaction.commit();
//        }
//        catch (HibernateException ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return result;
//    }
//
//
////    dont want to do it this way because it returns an object, we want a book to be a book and an author to be an author
//    public static Object getObjectById(int id, String className) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Object result = null;
//        try {
//            transaction = session.beginTransaction();
//            String hql = "from " + className + " where id = :id";
//            Query query =  session.createQuery(hql);
//            query.setInteger("id", id);
//            result = query.uniqueResult();
//            transaction.commit();
//        }
//        catch (HibernateException ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return result;
//    }



//    this is the best way to do it, it reutrns a generic single item that converts to the class that we return
    public static <T> T getGenericById(int id, String className) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from " + className + " where id = :id";
            Query query =  session.createQuery(hql);
            query.setInteger("id", id);
            result = (T) query.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
