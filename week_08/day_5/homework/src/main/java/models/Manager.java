package models;

import javax.persistence.*;

@Entity
@Table(name="managers")
public class Manager extends Employee {

    private Team team;
    private double winProportion;

    public Manager() {
    }

    public Manager(String name, int age) {
        super(name, age);
        this.winProportion = 0;
    }

    @OneToOne(mappedBy = "manager", fetch = FetchType.EAGER)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Column(name="win_proportion")
    public double getWinProportion() {
        return winProportion;
    }

    public void setWinProportion(double winProportion) {
        this.winProportion = winProportion;
    }

    public void updateWinProportion(int wins, int played) {
        double winsDouble = (double) wins;
        double playedDouble = (double) played;
        winProportion = winsDouble/playedDouble;
        this.winProportion = winProportion;
    }

}
