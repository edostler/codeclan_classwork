package db;

import models.Department;
import models.Employee;
import models.Manager;
import org.hibernate.*;
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

    public static <T> List<T> getList(Criteria criteria){
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUnique(Criteria criteria){
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T)criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> T find(Class classType, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(classType);
        criteria.add(Restrictions.idEq(id));
        result = getUnique(criteria);
        return result;
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }

    public static Manager getManagerOfDepartment(Department department) {
        session = HibernateUtil.getSessionFactory().openSession();
        Manager manager = null;
        Criteria criteria = session.createCriteria(Manager.class);
        criteria.add(Restrictions.eq("department", department));
        manager = getUnique(criteria);
        return manager;
    }

    public static <T> List<T> getEmployeesOfDepartment(Department department) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("department", department));
        results = getList(criteria);
        return results;
    }

    public static List<Employee> getEmployeesOfDepartment2(Department department) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> results = null;
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("department", department));
        results = getList(criteria);
        return results;
    }

}
