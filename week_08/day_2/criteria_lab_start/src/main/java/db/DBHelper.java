package db;

import models.Child;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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


    public static <T> List<T> getList(Criteria cr) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = cr.list();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUniqueResult(Criteria cr) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) cr.uniqueResult();
            transaction.commit();

        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }

    public static <T> T findByName(String name) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(Child.class);
        criteria.add(Restrictions.eq("name", name));
        result = (T) criteria.uniqueResult();
        return result;
    }

    public static List<Child> orderByAgeAsc() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;
        Criteria criteria = session.createCriteria(Child.class);
        criteria.addOrder(Order.asc("age"));
        results = getList(criteria);
        return results;
    }

    public static List<Child> orderByAgeDesc() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;
        Criteria criteria = session.createCriteria(Child.class);
        criteria.addOrder(Order.desc("age"));
        results = getList(criteria);
        return results;
    }

    public static List<Child> findByRange(String range) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;
        Criteria criteria = session.createCriteria(Child.class);
        criteria.add(Restrictions.eq("range", range));
        results = getList(criteria);
        return results;
    }

    public static List<Child> findByAgeLessThan(int age) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;
        Criteria criteria = session.createCriteria(Child.class);
        criteria.add(Restrictions.lt("age", age));
        results = getList(criteria);
        return results;
    }

    public static int getOldestAge() {
        session = HibernateUtil.getSessionFactory().openSession();
        int oldest;
        Criteria cr =  session.createCriteria(Child.class);
        cr.setProjection(Projections.max("age"));
        oldest = getUniqueResult(cr);
        return oldest;
    }

    public static <T> T getOldestChild() {
        T oldest = null;
        List<Child> results = null;
        results = DBHelper.orderByAgeDesc();
        oldest = (T) results.get(0);
        return oldest;
    }

    public static int getYoungestAge() {
        session = HibernateUtil.getSessionFactory().openSession();
        int youngest;
        Criteria cr =  session.createCriteria(Child.class);
        cr.setProjection(Projections.min("age"));
        youngest = getUniqueResult(cr);
        return youngest;
    }

    public static <T> T getYoungestChild() {
        T oldest = null;
        List<Child> results = null;
        results = DBHelper.orderByAgeAsc();
        oldest = (T) results.get(0);
        return oldest;
    }

    public static Double getAverageAge() {
        session = HibernateUtil.getSessionFactory().openSession();
        Double average = null;
        Criteria cr =  session.createCriteria(Child.class);
        cr.setProjection(Projections.avg("age"));
        average = (Double) getUniqueResult(cr);
        return average;
    }

    public static Long getTotalAge() {
        session = HibernateUtil.getSessionFactory().openSession();
        Long total;
        Criteria cr =  session.createCriteria(Child.class);
        cr.setProjection(Projections.sum("age"));
        total = getUniqueResult(cr);
        return total;
    }
}
