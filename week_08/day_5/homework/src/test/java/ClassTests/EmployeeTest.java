package ClassTests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private Manager manager;
    private Player player;
    private Team team;
    private Competition competition;

    @Before
    public void before() {
        competition = new Competition("Premier League 5s");
        team = new Team("Newcastle United", "St James' Park", competition);
        player = new Player("Alan Shearer", 41, team, PositionType.STRIKER, 9);
        manager = new Manager("Sir Bobby Robson", 82);
    }

    @Test
    public void canGetPlayerName() {
        assertEquals("Alan Shearer", player.getName());
    }

    @Test
    public void canGetManagerName() {
        assertEquals("Sir Bobby Robson", manager.getName());
    }

    @Test
    public void canGetPlayerAge() {
        assertEquals(41, player.getAge());
    }

    @Test
    public void canGetManagerAge() {
        assertEquals(82, manager.getAge());
    }

}
