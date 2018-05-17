package db;

import models.Manager;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
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

    public static void addManagerToTeam(Manager manager, Team team) {
        team.setManager(manager);
        manager.setTeam(team);
        saveOrUpdate(manager);
        saveOrUpdate(team);
    }

    public static void updateAfterGame(Team team1, int team1Score, Team team2, int team2Score) {
        team1.incrementGamesPlayed();
        team2.incrementGamesPlayed();

        if (team1Score > team2Score) {
            team1.incrementGamesWon();
            team2.incrementGamesLost();
            team1.increasePointsForWin();
        }
        else if (team2Score > team1Score) {
            team1.incrementGamesLost();
            team2.incrementGamesWon();
            team2.increasePointsForWin();
        }
        else {
            team1.incrementGamesDrawn();
            team2.incrementGamesDrawn();
            team1.increasePointsForDraw();
            team2.increasePointsForDraw();
        }

        team1.increaseGoalsScored(team1Score);
        team2.increaseGoalsScored(team2Score);

        team1.increaseGoalsConceded(team2Score);
        team2.increaseGoalsConceded(team1Score);

        team1.updateGoalDifference();
        team2.updateGoalDifference();

        saveOrUpdate(team1);
        saveOrUpdate(team2);

        Manager team1Manager = team1.getManager();
        Manager team2Manager = team2.getManager();

        team1Manager.updateWinProportion(team1.getGamesWon(), team1.getGamesPlayed());
        team2Manager.updateWinProportion(team2.getGamesWon(), team2.getGamesPlayed());

        saveOrUpdate(team1Manager);
        saveOrUpdate(team2Manager);

    }

    public static List<Team> getAllTeamsOrderedByPoints(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> results = null;
        Criteria criteria = session.createCriteria(Team.class);
        criteria.addOrder(Order.desc("points"));
        results = getList(criteria);
        return results;
    }

}
