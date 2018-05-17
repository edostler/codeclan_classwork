package db;

import models.Folder;
import models.File;
import models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

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

    public static void delete(Object object) {
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

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria cr = session.createCriteria(classType);
        results = getList(cr);
        return results;
    }

    public static List<File> getFilesByFolder(Folder folder) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<File> results = null;
        Criteria criteria = session.createCriteria(File.class);
        criteria.add(Restrictions.eq("folder", folder));
        results = getList(criteria);
        return results;
    }

    public static List<Folder> getFoldersByOwner(Owner owner) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Folder> results = null;
        Criteria criteria = session.createCriteria(Folder.class);
        criteria.add(Restrictions.eq("owner", owner));
        results = getList(criteria);
        return results;
    }

}
