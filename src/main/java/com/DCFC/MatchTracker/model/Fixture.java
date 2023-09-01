package com.DCFC.MatchTracker.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fixture extends Match {


    protected Fixture() {
    }

    public Fixture(Integer matchId, String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String skySportsURL) {
        super(matchId, homeTeam, awayTeam, kickoffDate, kickoffTime, skySportsURL);
    }

    public Fixture(String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String skySportsURL) {
        super(homeTeam, awayTeam, kickoffDate, kickoffTime, skySportsURL);
    }
}
