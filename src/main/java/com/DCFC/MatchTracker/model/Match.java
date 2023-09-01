package com.DCFC.MatchTracker.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;
import java.time.LocalTime;

@MappedSuperclass
public abstract class Match {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matchId;

    private String homeTeam;

    private String awayTeam;

    private LocalDate kickoffDate;

    private LocalTime kickoffTime;

    private String skySportsURL;

    protected Match() {

    }

    public Match(Integer matchId, String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String skySportsURL) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoffDate = kickoffDate;
        this.kickoffTime = kickoffTime;
        this.skySportsURL = skySportsURL;
    }

    public Match(String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String skySportsURL) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoffDate = kickoffDate;
        this.kickoffTime = kickoffTime;
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
