package com.DCFC.MatchTracker.dto;

import jakarta.persistence.Column;

public class MatchResultDTO {

    private String homeTeam;

    private String awayTeam;

    private int homeScore;

    private int awayScore;

    private String kickoff;

    private String competition;

    private String stadium;

    private String result;

    private String season;

    private String penaltiesScore;

    public MatchResultDTO() {

    }

    public MatchResultDTO(String homeTeam, String awayTeam, int homeScore, int awayScore, String kickoff, String competition, String stadium, String result, String season, String penaltiesScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.kickoff = kickoff;
        this.competition = competition;
        this.stadium = stadium;
        this.result = result;
        this.season = season;
        this.penaltiesScore = penaltiesScore;
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

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getKickoff() {
        return kickoff;
    }

    public void setKickoff(String kickoff) {
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
