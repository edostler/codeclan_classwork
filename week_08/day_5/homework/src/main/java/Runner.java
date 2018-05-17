import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Competition competition = new Competition("Premier League 5s");
        DBHelper.saveOrUpdate(competition);

        Team team1 = new Team("Newcastle United", "St James' Park", competition);
        DBHelper.saveOrUpdate(team1);

        Team team2 = new Team("Arsenal", "Highbury", competition);
        DBHelper.saveOrUpdate(team2);

        Player player1 = new Player("Alan Shearer", 41, team1, PositionType.STRIKER, 9);
        DBHelper.saveOrUpdate(player1);

        Player player2 = new Player("Shay Given", 40, team1, PositionType.GOALKEEPER, 1);
        DBHelper.saveOrUpdate(player2);

        Player player3 = new Player("Tony Adams", 45, team2, PositionType.DEFENDER, 7);
        DBHelper.saveOrUpdate(player3);

        Player player4 = new Player("Marc Overmars", 44, team2, PositionType.MIDFIELDER, 10);
        DBHelper.saveOrUpdate(player4);

        Manager manager1 = new Manager("Sir Bobby Robson", 82);
        DBHelper.saveOrUpdate(manager1);

        Manager manager2 = new Manager("Arsene Wenger", 78);
        DBHelper.saveOrUpdate(manager2);

        DBHelper.addManagerToTeam(manager1, team1);
        DBHelper.addManagerToTeam(manager2, team2);

        DBHelper.updateAfterGame(team1, 5, team2, 1);

        List<Team> orderedTeams = DBHelper.getAllTeamsOrderedByPoints();
    }

}
