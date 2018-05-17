package models;

import javax.persistence.*;

@Entity
@Table(name="players")
public class Player extends Employee {

    private Team team;
    private PositionType position;
    private int shirtNumber;
    private int goalsScored;
    private int goalsAssisted;

    public Player() {
    }

    public Player(String name, int age, Team team, PositionType position, int shirtNumber) {
        super(name, age);
        this.team = team;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.goalsScored = 0;
        this.goalsAssisted = 0;
    }

    @ManyToOne
    @JoinColumn(name="team_id", nullable=false)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Column(name="position")
    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    @Column(name="shirt_number")
    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @Column(name="goals_scored")
    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    @Column(name="goals_assisted")
    public int getGoalsAssisted() {
        return goalsAssisted;
    }

    public void setGoalsAssisted(int goalsAssisted) {
        this.goalsAssisted = goalsAssisted;
    }


    public void incrementGoalsScored() {
        this.goalsScored += 1;
    }

    public void incrementGoalsAssisted() {
        this.goalsAssisted += 1;
    }
}
