package com.DCFC.MatchTracker.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Match {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer matchId;

    @Column(name = "home_team")
    private String homeTeam;


    @Column(name = "away_team")
    private String awayTeam;

    @Column(name = "kickoff")
    private LocalDateTime kickoff;

    @Column(name = "competition")
    private String competition;

    @Column(name = "stadium")
    private String stadium;

    protected Match() {

    }

    public Match(Integer matchId, String homeTeam, String awayTeam, LocalDateTime kickoff, String competition, String stadium) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoff = kickoff;
        this.competition = competition;
        this.stadium = stadium;
    }

    public Match(String homeTeam, String awayTeam, LocalDateTime kickoff, String competition, String stadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoff = kickoff;
        this.competition = competition;
        this.stadium = stadium;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public LocalDateTime getKickoff() {
        return kickoff;
    }

    public void setKickoff(LocalDateTime kickoff) {
        this.kickoff = kickoff;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", kickoffDate=" + kickoff +
                '}';
    }
}
