package com.DCFC.MatchTracker.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "league_table")
public class LeagueTable {

    @Id
    private String team;


    @Column(name = "league_position")
    private int leaguePosition;


    @Column(name = "games_played")
    private int gamesPlayed;


    @Column(name = "wins")
    private int wins;


    @Column(name = "draws")
    private int draws;


    @Column(name = "losses")
    private int losses;


    @Column(name = "goals_for")
    private int goalsFor;


    @Column(name = "goals_against")
    private int goalsAgainst;


    @Column(name = "goal_difference")
    private int goalDifference;



    @Column(name = "points")
    private int points;


    protected LeagueTable() {
    }

    public LeagueTable(String team, int leaguePosition, int gamesPlayed, int wins, int draws, int losses, int goalsFor, int goalsAgainst, int goalDifference, int points) {
        this.team = team;
        this.leaguePosition = leaguePosition;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
