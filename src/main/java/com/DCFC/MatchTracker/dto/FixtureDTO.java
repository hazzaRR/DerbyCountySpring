package com.DCFC.MatchTracker.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class FixtureDTO {

    private String homeTeam;

    private String awayTeam;


    private String kickoffDate;

    private String kickoffTime;


    private String competition;

    private String stadium;

    private String skySportsURL;

    public FixtureDTO() {
    }

    public FixtureDTO(String homeTeam, String awayTeam, String kickoffDate, String kickoffTime, String competition, String stadium, String skySportsURL) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoffDate = kickoffDate;
        this.kickoffTime = kickoffTime;
        this.competition = competition;
        this.stadium = stadium;
        this.skySportsURL = skySportsURL;
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

    public String getKickoffDate() {
        return kickoffDate;
    }

    public void setKickoffDate(String kickoffDate) {
        this.kickoffDate = kickoffDate;
    }

    public String getKickoffTime() {
        return kickoffTime;
    }

    public void setKickoffTime(String kickoffTime) {
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
}
