//package db;
//
//import models.Employee;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class DBEmployee {
//    private static Transaction transaction;
//    private static Session session;
//
//    public static void saveEmployee(Employee employee) {
//
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.save(employee);
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    public static List<Employee> getEmployees()
//    {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Employee> employees = null;
//        try {
//            transaction = session.beginTransaction();
//            String hql = "from Employee";
//            employees = session.createQuery(hql).list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return employees;
//    }
//
//    public static void deleteAll(){
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            String hql = "delete from Employee";
//            Query query = session.createQuery(hql);
//            query.executeUpdate();
//        } catch (HibernateException e){
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//}