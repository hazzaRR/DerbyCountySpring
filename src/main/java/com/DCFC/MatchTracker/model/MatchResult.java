package com.DCFC.MatchTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "match_results")
public class MatchResult extends Match {

    private Integer homeScore;

    private Integer awayScore;


    protected MatchResult() {
    }

    public MatchResult(Integer matchId, String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String competition, String skySportsURL, Integer homeScore, Integer awayScore) {
        super(matchId, homeTeam, awayTeam, kickoffDate, kickoffTime, competition, skySportsURL);
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public MatchResult(String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String competition, String skySportsURL, Integer homeScore, Integer awayScore) {
        super(homeTeam, awayTeam, kickoffDate, kickoffTime, competition, skySportsURL);
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
