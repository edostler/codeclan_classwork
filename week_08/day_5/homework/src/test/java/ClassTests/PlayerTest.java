package ClassTests;

import models.Competition;
import models.Player;
import models.PositionType;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Team team;
    private Competition competition;

    @Before
    public void before() {
        competition = new Competition("Premier League 5s");
        team = new Team("Newcastle United", "St James' Park", competition);
        player = new Player("Alan Shearer", 41, team, PositionType.STRIKER, 9);
    }

    @Test
    public void canGetPosition() {
        assertEquals("Striker", player.getPosition().getPosition());
    }

    @Test
    public void canGetShirtNumber() {
        assertEquals(9, player.getShirtNumber());
    }

    @Test
    public void canGetGoalsScored() {
        assertEquals(0, player.getGoalsScored());
    }

    @Test
    public void canGetGoalsAssisted() {
        assertEquals(0, player.getGoalsAssisted());
    }

    @Test
    public void canSetGoalsScored() {
        player.setGoalsScored(1);
        assertEquals(1, player.getGoalsScored());
    }

    @Test
    public void canSetGoalsAssisted() {
        player.setGoalsAssisted(1);
        assertEquals(1, player.getGoalsAssisted());
    }

    @Test
    public void canGetPlayerTeam() {
        Team foundTeam = player.getTeam();
        assertEquals("Newcastle United", foundTeam.getName());    }

    @Test
    public void canSetPlayerTeam() {
        player.setTeam(team);
        Team foundTeam = player.getTeam();
        assertEquals("Newcastle United", foundTeam.getName());
    }

    @Test
    public void canIncrementGoalsScored() {
        player.incrementGoalsScored();
        assertEquals(1, player.getGoalsScored());
    }

    @Test
    public void canIncrementGoalsAssisted() {
        player.incrementGoalsAssisted();
        assertEquals(1, player.getGoalsAssisted());
    }

}
