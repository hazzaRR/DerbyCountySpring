package com.DCFC.MatchTracker.service;


import com.DCFC.MatchTracker.dto.FixtureDTO;
import com.DCFC.MatchTracker.model.Fixture;
import com.DCFC.MatchTracker.repository.FixtureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FixtureService {


    private FixtureRepository fixtureRepository;

    public FixtureService(FixtureRepository fixtureRepository) {
        this.fixtureRepository = fixtureRepository;
    }

    public List<Fixture> getFixtures() {
        return fixtureRepository.findAll();
    }

    public void addFixture(FixtureDTO fixture) {

        DateTimeFormatter formatter
                = DateTimeFormatter.ISO_LOCAL_TIME;

        Fixture newFixture = new Fixture(fixture.getHomeTeam(), fixture.getAwayTeam(),
                LocalDate.parse(fixture.getKickoffDate()), LocalTime.parse(fixture.getKickoffTime(), formatter), fixture.getCompetition(), fixture.getSkySportsURL());

        Fixture savedFixture = fixtureRepository.save(newFixture);
    }

    public void deleteFixtures() {
        fixtureRepository.deleteAll();
    }

    public void deleteFixture(int fixtureId) {
        fixtureRepository.deleteById(fixtureId);
    }

    public List<Fixture> getFixturesByYear(String year) {

       return fixtureRepository.findFixturesByYear("%"+year+"%");
    }

    public List<Fixture> getFixturesByYearAndCompetitionAndStadiumAndTeam(String year, String competition, String stadium, String team) {
        return new ArrayList<>();
    }
}
