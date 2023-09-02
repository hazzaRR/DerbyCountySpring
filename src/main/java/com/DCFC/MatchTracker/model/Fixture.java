package com.DCFC.MatchTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "upcoming_fixtures")
public class Fixture extends Match {


    protected Fixture() {
    }


    public Fixture(Integer matchId, String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String competition, String skySportsURL) {
        super(matchId, homeTeam, awayTeam, kickoffDate, kickoffTime, competition, skySportsURL);
    }

    public Fixture(String homeTeam, String awayTeam, LocalDate kickoffDate, LocalTime kickoffTime, String competition, String skySportsURL) {
        super(homeTeam, awayTeam, kickoffDate, kickoffTime, competition, skySportsURL);
    }
}
