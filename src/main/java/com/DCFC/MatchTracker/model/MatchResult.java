package com.DCFC.MatchTracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table(name = "match_results",
        uniqueConstraints = {
                @UniqueConstraint(name = "UniqueMatchResult", columnNames = {"home_team", "away_team", "kickoff", "competition"})})
public class MatchResult extends Match {

    @Column(name = "home_score")
    private Integer homeScore;

    @Column(name = "away_score")
    private Integer awayScore;

    @Column(name = "result")
    private String result;

    @Column(name = "season")
    private String season;

    @Column(name = "penalties_score")
    private String penaltiesScore;


    protected MatchResult() {
    }

    public MatchResult(Integer matchId, String homeTeam, String awayTeam, LocalDateTime kickoff, String competition, String stadium, Integer homeScore, Integer awayScore, String result, String season, String penaltiesScore) {
        super(matchId, homeTeam, awayTeam, kickoff, competition, stadium);
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.result = result;
        this.season = season;
        this.penaltiesScore = penaltiesScore;
    }

    public MatchResult(String homeTeam, String awayTeam, LocalDateTime kickoff, String competition, String stadium, Integer homeScore, Integer awayScore, String result, String season, String penaltiesScore) {
        super(homeTeam, awayTeam, kickoff, competition, stadium);
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.result = result;
        this.season = season;
        this.penaltiesScore = penaltiesScore;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getPenaltiesScore() {
        return penaltiesScore;
    }

    public void setPenaltiesScore(String penaltiesScore) {
        this.penaltiesScore = penaltiesScore;
    }
}
