package com.DCFC.MatchTracker.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MatchResult extends Match {

    private Integer homeScore;

    private Integer awayScore;


    protected MatchResult() {
    }

    public MatchResult(Integer matchId, String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String skySportsURL, Integer homeScore, Integer awayScore) {
        super(matchId, homeTeam, awayTeam, kickoffDate, kickoffTime, skySportsURL);
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public MatchResult(String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String skySportsURL, Integer homeScore, Integer awayScore) {
        super(homeTeam, awayTeam, kickoffDate, kickoffTime, skySportsURL);
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
