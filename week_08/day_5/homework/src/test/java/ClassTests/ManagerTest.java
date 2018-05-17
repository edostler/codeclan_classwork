package ClassTests;

import models.Competition;
import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    private Manager manager;
    private Team team;
    private Competition competition;

    @Before
    public void before() {
        competition = new Competition("Premier League 5s");
        manager = new Manager("Sir Bobby Robson", 82);
        team = new Team("Newcastle United", "St James' Park", competition);
    }

    @Test
    public void canGetManagerTeam() {
        assertEquals(null, manager.getTeam());
    }

    @Test
    public void canSetManagerTeam() {
        manager.setTeam(team);
        Team foundTeam = manager.getTeam();
        assertEquals("Newcastle United", foundTeam.getName());
    }

    @Test
    public void canGetWinProportion() {
        assertEquals(0, manager.getWinProportion(), 0.01);
    }

    @Test
    public void canSetWinProportion() {
        double proportion = 1.0/3.0;
        manager.setWinProportion(proportion);
        assertEquals(0.33, manager.getWinProportion(), 0.01);
    }

    @Test
    public void canUpdateWinProportion() {
        manager.updateWinProportion(1, 3);
        assertEquals(0.33, manager.getWinProportion(), 0.01);
    }

}
