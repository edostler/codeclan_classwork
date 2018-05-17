package DBTests;

import db.DBHelper;
import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DBHelperTest {

    private Team team1;
    private Team team2;
    private Player player;
    private Competition competition;
    private Manager manager1;
    private Manager manager2;

    @Before
    public void before() {
        competition = new Competition("Premier League 5s");
        team1 = new Team("Newcastle United", "St James' Park", competition);
        player = new Player("Alan Shearer", 41, team1, PositionType.STRIKER, 9);
        manager1 = new Manager("Sir Bobby Robson", 82);
        DBHelper.saveOrUpdate(competition);
        DBHelper.saveOrUpdate(team1);
        DBHelper.saveOrUpdate(player);
        DBHelper.saveOrUpdate(manager1);
    }

    @After
    public void after() {
        DBHelper.delete(player);
        DBHelper.delete(team1);
        DBHelper.delete(manager1);
        DBHelper.delete(competition);
        List<Competition> foundCompetitions = DBHelper.getAll(Competition.class);
        assertEquals(0, foundCompetitions.size());
        List<Team> foundTeams = DBHelper.getAll(Team.class);
        assertEquals(0, foundTeams.size());
        List<Player> foundPlayers = DBHelper.getAll(Player.class);
        assertEquals(0, foundPlayers.size());
        List<Manager> foundManagers = DBHelper.getAll(Manager.class);
        assertEquals(0, foundManagers.size());
    }

    @Test
    public void canSave__Competition() {
        List<Competition> foundCompetitions = DBHelper.getAll(Competition.class);
        assertEquals(1, foundCompetitions.size());
    }

    @Test
    public void canSave__Team() {
        List<Team> foundTeams = DBHelper.getAll(Team.class);
        assertEquals(1, foundTeams.size());
    }

    @Test
    public void canSave__Player() {
        List<Player> foundPlayers = DBHelper.getAll(Player.class);
        assertEquals(1, foundPlayers.size());
    }

    @Test
    public void canSave__Manager() {
        List<Manager> foundManagers = DBHelper.getAll(Manager.class);
        assertEquals(1, foundManagers.size());
    }

    @Test
    public void canUpdate_Competition() {
        Competition foundCompetition = DBHelper.find(Competition.class, competition.getId());
        foundCompetition.setName("Test");
        DBHelper.saveOrUpdate(foundCompetition);
        foundCompetition = DBHelper.find(Competition.class, competition.getId());
        assertEquals("Test", foundCompetition.getName());
    }

    @Test
    public void canUpdate_Team() {
        Team foundTeam = DBHelper.find(Team.class, team1.getId());
        foundTeam.setName("Test");
        DBHelper.saveOrUpdate(foundTeam);
        foundTeam = DBHelper.find(Team.class, team1.getId());
        assertEquals("Test", foundTeam.getName());
    }

    @Test
    public void canUpdate_Player() {
        Player foundPlayer = DBHelper.find(Player.class, player.getId());
        foundPlayer.setName("Test");
        DBHelper.saveOrUpdate(foundPlayer);
        foundPlayer = DBHelper.find(Player.class, player.getId());
        assertEquals("Test", foundPlayer.getName());
    }

    @Test
    public void canUpdate_Manager() {
        Manager foundManager = DBHelper.find(Manager.class, manager1.getId());
        foundManager.setName("Test");
        DBHelper.saveOrUpdate(foundManager);
        foundManager = DBHelper.find(Manager.class, manager1.getId());
        assertEquals("Test", foundManager.getName());
    }

//    @Test
//    public void canDelete() {
//        DBHelper.delete(player);
//        DBHelper.delete(team1);
//        DBHelper.delete(manager1);
//        DBHelper.delete(competition);
//        List<Competition> foundCompetitions = DBHelper.getAll(Competition.class);
//        assertEquals(0, foundCompetitions.size());
//        List<Team> foundTeams = DBHelper.getAll(Team.class);
//        assertEquals(0, foundTeams.size());
//        List<Player> foundPlayers = DBHelper.getAll(Player.class);
//        assertEquals(0, foundPlayers.size());
//        List<Manager> foundManagers = DBHelper.getAll(Manager.class);
//        assertEquals(0, foundManagers.size());
//    }

    @Test
    public void canAddManagerToTeam() {
        DBHelper.addManagerToTeam(manager1, team1);
        Team foundTeam = DBHelper.find(Team.class, team1.getId());
        Manager foundManager = foundTeam.getManager();
        assertEquals("Sir Bobby Robson", foundManager.getName());
    }

    @Test
    public void canUpdateAfterGame__Team1Wins() {
        team2 = new Team("Arsenal", "Highbury", competition);
        DBHelper.saveOrUpdate(team2);
        manager2 = new Manager("Arsene Wenger", 78);
        DBHelper.saveOrUpdate(manager2);
        DBHelper.addManagerToTeam(manager1, team1);
        DBHelper.addManagerToTeam(manager2, team2);

        DBHelper.updateAfterGame(team1, 5, team2, 1);

        Team foundTeam1 = DBHelper.find(Team.class, team1.getId());
        Team foundTeam2 = DBHelper.find(Team.class, team2.getId());
        Manager foundManager1 = DBHelper.find(Manager.class, manager1.getId());
        Manager foundManager2 = DBHelper.find(Manager.class, manager2.getId());

        assertEquals(1, foundTeam1.getGamesPlayed());
        assertEquals(1, foundTeam1.getGamesWon());
        assertEquals(0, foundTeam1.getGamesDrawn());
        assertEquals(0, foundTeam1.getGamesLost());
        assertEquals(5, foundTeam1.getGoalsScored());
        assertEquals(1, foundTeam1.getGoalsConceded());
        assertEquals(4, foundTeam1.getGoalDifference());
        assertEquals(3, foundTeam1.getPoints());

        assertEquals(1, foundTeam2.getGamesPlayed());
        assertEquals(0, foundTeam2.getGamesWon());
        assertEquals(0, foundTeam2.getGamesDrawn());
        assertEquals(1, foundTeam2.getGamesLost());
        assertEquals(1, foundTeam2.getGoalsScored());
        assertEquals(5, foundTeam2.getGoalsConceded());
        assertEquals(-4, foundTeam2.getGoalDifference());
        assertEquals(0, foundTeam2.getPoints());

        DBHelper.delete(team2);
        DBHelper.delete(manager2);
    }

    @Test
    public void canUpdateAfterGame__Team2Wins() {
        team2 = new Team("Arsenal", "Highbury", competition);
        DBHelper.saveOrUpdate(team2);
        manager2 = new Manager("Arsene Wenger", 78);
        DBHelper.saveOrUpdate(manager2);
        DBHelper.addManagerToTeam(manager1, team1);
        DBHelper.addManagerToTeam(manager2, team2);

        DBHelper.updateAfterGame(team1, 1, team2, 2);

        Team foundTeam1 = DBHelper.find(Team.class, team1.getId());
        Team foundTeam2 = DBHelper.find(Team.class, team2.getId());
        Manager foundManager1 = DBHelper.find(Manager.class, manager1.getId());
        Manager foundManager2 = DBHelper.find(Manager.class, manager2.getId());

        assertEquals(1, foundTeam1.getGamesPlayed());
        assertEquals(0, foundTeam1.getGamesWon());
        assertEquals(0, foundTeam1.getGamesDrawn());
        assertEquals(1, foundTeam1.getGamesLost());
        assertEquals(1, foundTeam1.getGoalsScored());
        assertEquals(2, foundTeam1.getGoalsConceded());
        assertEquals(-1, foundTeam1.getGoalDifference());
        assertEquals(0, foundTeam1.getPoints());

        assertEquals(1, foundTeam2.getGamesPlayed());
        assertEquals(1, foundTeam2.getGamesWon());
        assertEquals(0, foundTeam2.getGamesDrawn());
        assertEquals(0, foundTeam2.getGamesLost());
        assertEquals(2, foundTeam2.getGoalsScored());
        assertEquals(1, foundTeam2.getGoalsConceded());
        assertEquals(1, foundTeam2.getGoalDifference());
        assertEquals(3, foundTeam2.getPoints());

        DBHelper.delete(team2);
        DBHelper.delete(manager2);
    }

    @Test
    public void canUpdateAfterGame__Draw() {
        team2 = new Team("Arsenal", "Highbury", competition);
        DBHelper.saveOrUpdate(team2);
        manager2 = new Manager("Arsene Wenger", 78);
        DBHelper.saveOrUpdate(manager2);
        DBHelper.addManagerToTeam(manager1, team1);
        DBHelper.addManagerToTeam(manager2, team2);

        DBHelper.updateAfterGame(team1, 3, team2, 3);

        Team foundTeam1 = DBHelper.find(Team.class, team1.getId());
        Team foundTeam2 = DBHelper.find(Team.class, team2.getId());
        Manager foundManager1 = DBHelper.find(Manager.class, manager1.getId());
        Manager foundManager2 = DBHelper.find(Manager.class, manager2.getId());

        assertEquals(1, foundTeam1.getGamesPlayed());
        assertEquals(0, foundTeam1.getGamesWon());
        assertEquals(1, foundTeam1.getGamesDrawn());
        assertEquals(0, foundTeam1.getGamesLost());
        assertEquals(3, foundTeam1.getGoalsScored());
        assertEquals(3, foundTeam1.getGoalsConceded());
        assertEquals(0, foundTeam1.getGoalDifference());
        assertEquals(1, foundTeam1.getPoints());

        assertEquals(1, foundTeam2.getGamesPlayed());
        assertEquals(0, foundTeam2.getGamesWon());
        assertEquals(1, foundTeam2.getGamesDrawn());
        assertEquals(0, foundTeam2.getGamesLost());
        assertEquals(3, foundTeam2.getGoalsScored());
        assertEquals(3, foundTeam2.getGoalsConceded());
        assertEquals(0, foundTeam2.getGoalDifference());
        assertEquals(1, foundTeam2.getPoints());

        DBHelper.delete(team2);
        DBHelper.delete(manager2);
    }

    @Test
    public void canGetAllTeamsOrderedByPoints() {
        team2 = new Team("Arsenal", "Highbury", competition);
        DBHelper.saveOrUpdate(team2);
        manager2 = new Manager("Arsene Wenger", 78);
        DBHelper.saveOrUpdate(manager2);
        DBHelper.addManagerToTeam(manager1, team1);
        DBHelper.addManagerToTeam(manager2, team2);
        DBHelper.updateAfterGame(team1, 2, team2, 3);

        List<Team> foundTeamsBefore = DBHelper.getAll(Team.class);
        Team firstTeamBefore = foundTeamsBefore.get(0);
        assertEquals("Newcastle United", firstTeamBefore.getName());

        List<Team> foundTeamsAfter = DBHelper.getAllTeamsOrderedByPoints();
        Team firstTeamAfter = foundTeamsAfter.get(0);
        assertEquals("Arsenal", firstTeamAfter.getName());

        DBHelper.delete(team2);
        DBHelper.delete(manager2);
    }

}
