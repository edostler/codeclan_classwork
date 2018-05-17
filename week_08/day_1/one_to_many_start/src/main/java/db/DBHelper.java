package db;

import models.Employee;
import org.hibernate.*;

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
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    public static void save(Object object) {
//
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.save(object);
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    public static void update(Object object) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.update(object);
//            transaction.commit();
//        }
//        catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
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
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }

    public static void deleteAll(String className){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "delete from" + className;
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Employee> getEmployees(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Employee WHERE department_id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            employees = query.list();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return employees;
    }

    public static void deleteById(int id, String className) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "delete from " + className + " where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            query.executeUpdate();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

}
