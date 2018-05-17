package ClassTests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TeamTest {

    private Team team;
    private Player player1;
    private Player player2;
    private Competition competition;
    private Manager manager;

    @Before
    public void before() {
        competition = new Competition("Premier League 5s");
        team = new Team("Newcastle United", "St James' Park", competition);
        player1 = new Player("Alan Shearer", 41, team, PositionType.STRIKER, 9);
        player2 = new Player("Shay Given", 40, team, PositionType.GOALKEEPER, 1);
        manager = new Manager("Sir Bobby Robson", 82);
    }

    @Test
    public void canGetName() {
        assertEquals("Newcastle United", team.getName());
    }

    @Test
    public void canGetStadium() {
        assertEquals("St James' Park", team.getStadium());
    }

    @Test
    public void canGetCompetition() {
        Competition foundCompetition = team.getCompetition();
        assertEquals("Premier League 5s", foundCompetition.getName());    }

    @Test
    public void canGetManager() {
        assertEquals(null, team.getManager());
    }

    @Test
    public void canGetTeamCapacity() {
        assertEquals(5, team.getTeamCapacity());
    }

    @Test
    public void canGetPlayersSize() {
        assertEquals(0, team.checkPlayersSize());
    }

    @Test
    public void canAddPlayerToTeam__SpaceAvailable() {
        team.addPlayerToTeam(player1);
        team.addPlayerToTeam(player2);
        assertEquals(2, team.checkPlayersSize());
    }

    @Test
    public void canAddPlayerToTeam__SpaceUnavailable() {
        team.setTeamCapacity(1);
        team.addPlayerToTeam(player1);
        team.addPlayerToTeam(player2);
        assertEquals(1, team.checkPlayersSize());
    }

    @Test
    public void canSetCompetition() {
        team.setCompetition(competition);
        Competition foundCompetition = team.getCompetition();
        assertEquals("Premier League 5s", foundCompetition.getName());
    }

    @Test
    public void canSetManager() {
        team.setManager(manager);
        Manager foundManager = team.getManager();
        assertEquals("Sir Bobby Robson", foundManager.getName());
    }

    @Test
    public void canSetGamePlayed() {
        team.setGamesPlayed(1);
        assertEquals(1, team.getGamesPlayed());
    }

    @Test
    public void canSetGameWon() {
        team.setGamesWon(1);
        assertEquals(1, team.getGamesWon());
    }

    @Test
    public void canSetGameDrawn() {
        team.setGamesDrawn(1);
        assertEquals(1, team.getGamesDrawn());
    }

    @Test
    public void canSetGameLost() {
        team.setGamesLost(1);
        assertEquals(1, team.getGamesLost());
    }

    @Test
    public void canSetGoalsScored() {
        team.setGoalsScored(1);
        assertEquals(1, team.getGoalsScored());
    }

    @Test
    public void canSetGoalsConceded() {
        team.setGoalsConceded(1);
        assertEquals(1, team.getGoalsConceded());
    }

    @Test
    public void canSetGoalDifference() {
        team.setGoalDifference(1);
        assertEquals(1, team.getGoalDifference());
    }

    @Test
    public void canSetPoints() {
        team.setPoints(1);
        assertEquals(1, team.getPoints());
    }

    @Test
    public void canIncrementGamesPlayed() {
        team.incrementGamesPlayed();
        assertEquals(1, team.getGamesPlayed());
    }

    @Test
    public void canIncrementGamesWon() {
        team.incrementGamesWon();
        assertEquals(1, team.getGamesWon());
    }

    @Test
    public void canIncrementGamesDrawn() {
        team.incrementGamesDrawn();
        assertEquals(1, team.getGamesDrawn());
    }

    @Test
    public void canIncrementGamesLost() {
        team.incrementGamesLost();
        assertEquals(1, team.getGamesLost());
    }

    @Test
    public void canIncreaseGoalsScored() {
        team.increaseGoalsScored(2);
        assertEquals(2, team.getGoalsScored());
    }

    @Test
    public void canIncreaseGoalsConceded() {
        team.increaseGoalsConceded(2);
        assertEquals(2, team.getGoalsConceded());
    }

    @Test
    public void canUpdateGoalDifference() {
        team.setGoalsScored(3);
        team.setGoalsConceded(1);
        team.updateGoalDifference();
        assertEquals(2, team.getGoalDifference());
    }

    @Test
    public void canIncreasePointsForWin() {
        team.increasePointsForWin();
        assertEquals(3, team.getPoints());
    }

    @Test
    public void canIncreasePointsForDraw() {
        team.increasePointsForDraw();
        assertEquals(1, team.getPoints());
    }

}
