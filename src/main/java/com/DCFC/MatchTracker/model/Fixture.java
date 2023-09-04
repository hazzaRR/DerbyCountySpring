package com.DCFC.MatchTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table(name = "upcoming_fixtures")
public class Fixture extends Match {


    protected Fixture() {
    }


    public Fixture(Integer matchId, String homeTeam, String awayTeam, LocalDateTime kickoff, String competition, String stadium, String skySportsURL) {
        super(matchId, homeTeam, awayTeam, kickoff, competition, stadium, skySportsURL);
    }

    public Fixture(String homeTeam, String awayTeam, LocalDateTime kickoff, String competition, String stadium, String skySportsURL) {
        super(homeTeam, awayTeam, kickoff, competition, stadium, skySportsURL);
    }
}
