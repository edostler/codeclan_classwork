package db;

import com.sun.xml.internal.bind.v2.model.core.ID;
import models.Department;
import models.Employee;
import org.hibernate.*;
import org.hibernate.annotations.Sort;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

public class DBHelper {
    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static void update(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    REFACTORED
//    public static <T> List<T> getAll(Class classType){
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<T> results = null;
//        try {
//            transaction = session.beginTransaction();
//            Criteria criteria = session.createCriteria(classType);
//            results = criteria.list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }

//    REFACTORED
//    public static <T> T findById(Class classType, int id) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        T result = null;
//        try {
//            transaction = session.beginTransaction();
//            Criteria cr = session.createCriteria(classType);
//            cr.add(Restrictions.eq("id", id));
//            result = (T) cr.uniqueResult();
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

//    THIS METHOD USES THE RESTRICTION idEq TO MATCH ID INSTEAD OF PASSING IN THE ID
//    REFACTORED
//    public static <T> T findById(Class classType, int id) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        T result = null;
//        try {
//            transaction = session.beginTransaction();
//            Criteria cr = session.createCriteria(classType);
//            cr.add(Restrictions.idEq(id));
//            result = (T) cr.uniqueResult();
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

    public static <T> T findById(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.idEq(id));
        result = (T) cr.uniqueResult();
        return result;
    }

//    REFACTORED
//    public static List<Employee> findBySalaryGreaterThan(int salary) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Employee> results = null;
//        try {
//            transaction = session.beginTransaction();
//            Criteria cr = session.createCriteria(Employee.class);
//            cr.add(Restrictions.gt("salary", salary));
//            results = cr.list();
//            transaction.commit();
//        }
//        catch (HibernateException ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }

    public static List<Employee> findBySalaryGreaterThan(int salary) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> results = null;
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.gt("salary", salary));
        results = getList(criteria);
        return results;
    }

//    REFACTORED
//    public static List<Employee> orderBySalary() {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Employee> results = null;
//        try {
//            transaction = session.beginTransaction();
//            Criteria cr = session.createCriteria(Employee.class);
//            cr.addOrder(Order.desc("salary"));
//            results = cr.list();
//            transaction.commit();
//        }
//        catch (HibernateException ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }

    public static List<Employee> orderBySalary() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> results = null;
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.addOrder(Order.desc("salary"));
        results = getList(criteria);
        return results;
    }

//    REFACTORED
//    public static Double getAverageSalary() {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Double average = null;
//        try {
//            transaction = session.beginTransaction();
//            Criteria cr =  session.createCriteria(Employee.class);
//            cr.setProjection(Projections.avg("salary"));
//            average = (Double) cr.uniqueResult();
//            transaction.commit();
//        }
//        catch (HibernateException ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return average;
//    }

    public static Double getAverageSalary() {
        session = HibernateUtil.getSessionFactory().openSession();
        Double average = null;
        Criteria cr =  session.createCriteria(Employee.class);
        cr.setProjection(Projections.avg("salary"));
        average = (Double) getUniqueResult(cr);
        return average;
    }

//    REFECTORING FOR REPETITION
    public static <T> List<T> getList(Criteria cr) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = cr.list();
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUniqueResult(Criteria cr) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) cr.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return result;
    }




}
