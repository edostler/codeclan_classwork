package ClassTests;

import models.Competition;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompetitionTest {

    private Competition competition;
    private Team team1;
    private Team team2;

    @Before
    public void before() {
        competition = new Competition("Premier League 5s");
        team1 = new Team("Newcastle United", "St James' Park", competition);
        team2 = new Team("Arsenal", "Highbury", competition);
    }

    @Test
    public void canGetName() {
        assertEquals("Premier League 5s", competition.getName());
    }

    @Test
    public void canGetCompetitionCapacity() {
        assertEquals(4, competition.getCompetitionCapacity());
    }

    @Test
    public void canGetTeamsSize() {
        assertEquals(0, competition.checkTeamsSize());
    }

    @Test
    public void canAddTeamToCompetition__SpaceAvailable() {
        competition.addTeamToCompetition(team1);
        competition.addTeamToCompetition(team2);
        assertEquals(2, competition.checkTeamsSize());
    }

    @Test
    public void canAddTeamToCompetition__SpaceUnavailable() {
        competition.setCompetitionCapacity(1);
        competition.addTeamToCompetition(team1);
        competition.addTeamToCompetition(team2);
        assertEquals(1, competition.checkTeamsSize());
    }

}
