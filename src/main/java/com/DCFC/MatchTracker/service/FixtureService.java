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
                LocalDate.parse(fixture.getKickoffDate()), LocalTime.parse(fixture.getKickoffTime(), formatter), fixture.getCompetition(), fixture.getStadium(), fixture.getSkySportsURL());

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
        return fixtureRepository.findFixturesByYearAndCompetitionAndStadiumAndTeam(year, competition, stadium, team);
    }

    public List<Fixture> getFixturesByTeam(String team) {
        return fixtureRepository.findFixturesByTeam(team);
    }

    public List<Fixture> getFixturesByStadium(String stadium) {
        return fixtureRepository.findFixturesByStadium(stadium);
    }

    public List<Fixture> getFixturesByCompetition(String competition) {
        return fixtureRepository.findFixturesByCompetition(competition);
    }

    public List<Fixture> getFixturesByStadiumAndTeam(String stadium, String team) {
        return fixtureRepository.findFixturesByStadiumAndTeam(stadium, team);
    }

    public List<Fixture> getFixturesByCompetitionAndTeam(String competition, String team) {
        return fixtureRepository.findFixturesByCompetitionAndTeam(competition, team);
    }

    public List<Fixture> getFixturesByCompetitionAndStadium(String competition, String stadium) {
        return fixtureRepository.findFixturesByCompetitionAndStadium(competition, stadium);
    }

    public List<Fixture> getFixturesByYearAndTeam(String year, String team) {
        return fixtureRepository.findFixturesByYearAndTeam(year, team);
    }

    public List<Fixture> getFixturesByYearAndStadium(String year, String stadium) {
        return fixtureRepository.findFixturesByYearAndStadium(year, stadium);
    }

    public List<Fixture> getFixturesByYearAndCompetition(String year, String competition) {
        return fixtureRepository.findFixturesByYearAndCompetition(year, competition);
    }

    public List<Fixture> getFixturesByCompetitionAndStadiumAndTeam(String competition, String stadium, String team) {
        return fixtureRepository.findFixturesByCompetitionAndStadiumAndTeam(competition, stadium, team);
    }

    public List<Fixture> getFixturesByYearAndCompetitionAndStadium(String year, String competition, String stadium) {
        return fixtureRepository.findFixturesByYearAndCompetitionAndStadium(year, competition, stadium);
    }

    public List<Fixture> getFixturesByYearAndCompetitionAndTeam(String year, String competition, String team) {
        return fixtureRepository.findFixturesByYearAndCompetitionAndTeam(year, competition, team);
    }

    public List<Fixture> getFixturesByYearAndStadiumAndTeam(String year, String stadium, String team) {
        return fixtureRepository.findFixturesByYearAndStadiumAndTeam(year, stadium, team);
    }
}
