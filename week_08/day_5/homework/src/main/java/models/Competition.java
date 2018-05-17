package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="competitions")
public class Competition {

    private int id;
    private String name;
    private Set<Team> teams;
    private int competitionCapacity;

    public Competition() {
    }

    public Competition(String name) {
        this.name = name;
        this.teams = new HashSet<Team>();
        this.competitionCapacity = 4;
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

    @OneToMany(mappedBy="competition", fetch = FetchType.EAGER)
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Column(name="competition_capacity")
    public int getCompetitionCapacity() {
        return competitionCapacity;
    }

    public void setCompetitionCapacity(int competitionCapacity) {
        this.competitionCapacity = competitionCapacity;
    }

    public int checkTeamsSize() {
        return this.teams.size();
    }

    public void addTeamToCompetition(Team team) {
        if (this.teams.size() < this.competitionCapacity) {
            this.teams.add(team);
        }
    }


}
