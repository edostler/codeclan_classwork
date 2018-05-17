//package db;
//
//import models.Department;
//import models.Employee;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class DBDepartment {
//    private static Transaction transaction;
//    private static Session session;
//
//    public static void saveDepartment(Department department) {
//
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.save(department);
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    public static List<Department> getDepartments()
//    {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Department> departments = null;
//        try {
//            transaction = session.beginTransaction();
//            String hql = "from Department";
//            departments = session.createQuery(hql).list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return departments;
//    }
//
//    public static void deleteAll(){
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            String hql = "delete from Department";
//            Query query = session.createQuery(hql);
//            query.executeUpdate();
//            transaction.commit();
//        } catch (HibernateException e){
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    public static List<Employee> getEmployees(int id) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Employee> employees = null;
//        try {
//            transaction = session.beginTransaction();
//            String hql = "from Employee WHERE department_id = :id";
//            Query query = session.createQuery(hql);
//            query.setInteger("id", id);
//            employees = query.list();
//            transaction.commit();
//        }
//        catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//        return employees;
//    }
//}
