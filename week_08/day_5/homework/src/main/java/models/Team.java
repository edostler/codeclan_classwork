package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="teams")
public class Team {

    private int id;
    private String name;
    private String stadium;
    private Competition competition;
    private Manager manager;
    private Set<Player> players;
    private int teamCapacity;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDrawn;
    private int gamesLost;
    private int goalsScored;
    private int goalsConceded;
    private int goalDifference;
    private int points;

    public Team() {
    }

    public Team(String name, String stadium, Competition competition) {
        this.name = name;
        this.stadium = stadium;
        this.competition = competition;
        this.players = new HashSet<Player>();
        this.teamCapacity = 5;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesDrawn = 0;
        this.gamesLost = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.goalDifference = 0;
        this.points = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="stadium")
    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @ManyToOne
    @JoinColumn(name="competition_id", nullable=false)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Column(name="team_capacity")
    public int getTeamCapacity() {
        return teamCapacity;
    }

    public void setTeamCapacity(int teamCapacity) {
        this.teamCapacity = teamCapacity;
    }

    @Column(name="games_played")
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Column(name="games_won")
    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    @Column(name="games_drawn")
    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public void setGamesDrawn(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    @Column(name="games_lost")
    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    @Column(name="goals_scored")
    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    @Column(name="goals_conceded")
    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    @Column(name="goal_difference")
    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    @Column(name="points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }



    public int checkPlayersSize() {
        return this.players.size();
    }

    public void addPlayerToTeam(Player player) {
        if (this.players.size() < this.teamCapacity) {
            this.players.add(player);
        }
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed += 1;
    }

    public void incrementGamesWon() {
        this.gamesWon += 1;
    }

    public void incrementGamesDrawn() {
        this.gamesDrawn += 1;
    }

    public void incrementGamesLost() {
        this.gamesLost += 1;
    }

    public void increaseGoalsScored(int goalsScored) {
        this.goalsScored += goalsScored;
    }

    public void increaseGoalsConceded(int goalsConceded) {
        this.goalsConceded += goalsConceded;
    }

    public void updateGoalDifference() {
        goalDifference = this.goalsScored - this.goalsConceded;
        setGoalDifference(goalDifference);
    }

    public void increasePointsForWin() {
        this.points += 3;
    }

    public void increasePointsForDraw() {
        this.points += 1;
    }

}
