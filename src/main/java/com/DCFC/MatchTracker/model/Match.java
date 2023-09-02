package com.DCFC.MatchTracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@MappedSuperclass
public abstract class Match {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer matchId;

    @Column(name = "home_team")
    private String homeTeam;


    @Column(name = "away_team")
    private String awayTeam;

    @Column(name = "kickoff_date")
    private LocalDate kickoffDate;

    @Column(name = "kickoff_time")
    private LocalTime kickoffTime;

    @Column(name = "competition")
    private String competition;

    @Column(name = "stadium")
    private String stadium;

    @Column(name = "sky_sports_url")
    private String skySportsURL;

    protected Match() {

    }

    public Match(Integer matchId, String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String competition, String stadium, String skySportsURL) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoffDate = kickoffDate;
        this.kickoffTime = kickoffTime;
        this.competition = competition;
        this.stadium = stadium;
        this.skySportsURL = skySportsURL;
    }

    public Match(String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String competition, String stadium, String skySportsURL) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoffDate = kickoffDate;
        this.kickoffTime = kickoffTime;
        this.competition = competition;
        this.stadium = stadium;
        this.skySportsURL = skySportsURL;
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

    public LocalDate getKickoffDate() {
        return kickoffDate;
    }

    public void setKickoffDate(LocalDate kickoffDate) {
        this.kickoffDate = kickoffDate;
    }

    public LocalTime getKickoffTime() {
        return kickoffTime;
    }

    public void setKickoffTime(LocalTime kickoffTime) {
        this.kickoffTime = kickoffTime;
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

    public String getSkySportsURL() {
        return skySportsURL;
    }

    public void setSkySportsURL(String skySportsURL) {
        this.skySportsURL = skySportsURL;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", kickoffDate=" + kickoffDate +
                ", kickoffTime=" + kickoffTime +
                ", skySportsURL='" + skySportsURL + '\'' +
                '}';
    }
}
