package com.DCFC.MatchTracker.service;


import com.DCFC.MatchTracker.dto.FixtureDTO;
import com.DCFC.MatchTracker.model.Fixture;
import com.DCFC.MatchTracker.repository.FixtureRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

@Service
public class FixtureService {


    private final FixtureRepository fixtureRepository;

    public FixtureService(FixtureRepository fixtureRepository) {
        this.fixtureRepository = fixtureRepository;
    }

    public List<Fixture> getFixtures() {
        return fixtureRepository.findAll();
    }

    public void addFixture(FixtureDTO fixture) {

        System.out.println(fixture.getKickoff());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {

            Fixture newFixture = new Fixture(fixture.getHomeTeam(), fixture.getAwayTeam(),
                    LocalDateTime.parse(fixture.getKickoff(), formatter), fixture.getCompetition(), fixture.getStadium(), fixture.getSkySportsURL());

            Fixture savedFixture = fixtureRepository.save(newFixture);

        } catch (DateTimeParseException e) {
            System.err.println("Error parsing the date-time string: " + e.getMessage());
        }

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

    public List<Fixture> getFixturesByYearCompetitionStadiumTeam(String year, String competition, String stadium, String team) {
        return fixtureRepository.findFixturesByYearCompetitionStadiumTeam(year, competition, stadium, team);
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

    public List<Fixture> getFixturesByStadiumTeam(String stadium, String team) {
        return fixtureRepository.findFixturesByStadiumTeam(stadium, team);
    }

    public List<Fixture> getFixturesByCompetitionTeam(String competition, String team) {
        return fixtureRepository.findFixturesByCompetitionTeam(competition, team);
    }

    public List<Fixture> getFixturesByCompetitionStadium(String competition, String stadium) {
        return fixtureRepository.findFixturesByCompetitionStadium(competition, stadium);
    }

    public List<Fixture> getFixturesByYearTeam(String year, String team) {
        return fixtureRepository.findFixturesByYearTeam(year, team);
    }

    public List<Fixture> getFixturesByYearStadium(String year, String stadium) {
        return fixtureRepository.findFixturesByYearStadium(year, stadium);
    }

    public List<Fixture> getFixturesByYearCompetition(String year, String competition) {
        return fixtureRepository.findFixturesByYearCompetition(year, competition);
    }

    public List<Fixture> getFixturesByCompetitionStadiumTeam(String competition, String stadium, String team) {
        return fixtureRepository.findFixturesByCompetitionStadiumTeam(competition, stadium, team);
    }

    public List<Fixture> getFixturesByYearCompetitionStadium(String year, String competition, String stadium) {
        return fixtureRepository.findFixturesByYearCompetitionStadium(year, competition, stadium);
    }

    public List<Fixture> getFixturesByYearCompetitionTeam(String year, String competition, String team) {
        return fixtureRepository.findFixturesByYearCompetitionTeam(year, competition, team);
    }

    public List<Fixture> getFixturesByYearStadiumTeam(String year, String stadium, String team) {
        return fixtureRepository.findFixturesByYearStadiumTeam(year, stadium, team);
    }

    @Transactional
    public void updateFixture(int id, String homeTeam, String awayTeam, String kickoff, String competition, String stadium, String skySportsURL) {

        Fixture fixture = fixtureRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Fixture with id " + id + " does not exist"
        ));

        if(homeTeam != null && homeTeam.length() > 0 && !Objects.equals(fixture.getHomeTeam(), awayTeam)) {
            fixture.setHomeTeam(homeTeam);
        }

        if (awayTeam != null && awayTeam.length() > 0 && !Objects.equals(fixture.getAwayTeam(), awayTeam)) {
            fixture.setAwayTeam(awayTeam);
        }

        if (kickoff != null && kickoff.length() > 0 && !Objects.equals(fixture.getKickoff(), LocalDateTime.parse(kickoff))) {
            fixture.setKickoff(LocalDateTime.parse(kickoff));
        }


        if (competition != null && competition.length() > 0 && !Objects.equals(fixture.getCompetition(), competition)) {
            fixture.setCompetition(competition);
        }

        if (stadium != null && stadium.length() > 0 && !Objects.equals(fixture.getStadium(), stadium)) {
            fixture.setStadium(stadium);
        }
        if (skySportsURL != null && skySportsURL.length() > 0 && !Objects.equals(fixture.getSkySportsURL(), skySportsURL)) {
            fixture.setSkySportsURL(skySportsURL);
        }

    }

    public List<String> getCompetitions() {
        return fixtureRepository.findCompetitions();
    }

    public List<String> getTeamsInCompetition(String competition) {
        return fixtureRepository.findTeamsInCompetition(competition);
    }

    public List<String> getTeams() {
        return fixtureRepository.findTeams();
    }
}
