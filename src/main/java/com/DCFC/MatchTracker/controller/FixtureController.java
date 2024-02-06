package com.DCFC.MatchTracker.controller;


import com.DCFC.MatchTracker.dto.FixtureDTO;
import com.DCFC.MatchTracker.model.Fixture;
import com.DCFC.MatchTracker.service.FixtureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/fixtures")
public class FixtureController {


    private final FixtureService fixtureService;

    public FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "This is Derby County";
    }


    @GetMapping("/")
    public List<Fixture> getFixtures() {
        return fixtureService.getFixtures();
    }

    @GetMapping(path = "/find")
    public List<Fixture> getFixtures(
            @RequestParam(required = false) String competition,
            @RequestParam(required = false) String stadium,
            @RequestParam(required = false) String team
    ) {

        if (competition != null && stadium != null && team != null) {
            return fixtureService.getFixturesByCompetitionStadiumTeam(competition, stadium, team);
        }
        else if (competition != null && stadium != null) {
            return fixtureService.getFixturesByCompetitionStadium(competition, stadium);
        }
        else if (competition != null && team != null) {
            return fixtureService.getFixturesByCompetitionTeam(competition, team);
        }
        else if (stadium != null && team != null) {
            return fixtureService.getFixturesByStadiumTeam(stadium, team);
        }
        else if (competition != null) {
            return fixtureService.getFixturesByCompetition(competition);
        }
        else if (stadium != null) {
            return fixtureService.getFixturesByStadium(stadium);
        }
        else if (team != null) {
            return fixtureService.getFixturesByTeam(team);
        }
        else {
            return fixtureService.getFixtures();
        }
    }

    @GetMapping("/competitions")
    public List<String> getCompetitions() {
        return fixtureService.getCompetitions();
    }
    @GetMapping("/teams")
    List<String> teamsPlayedAgainst(@RequestParam(required = false) String competition) {

        if (competition != null) {
            return fixtureService.getTeamsInCompetition(competition);
        }
        return fixtureService.getTeams();
    }

    @GetMapping("/next-fixture")
    public Fixture getNextFixture() {
        return fixtureService.getNextFixture();
    }


    @DeleteMapping("/")
    public void deleteAllFixtures() {
        fixtureService.deleteFixtures();
    }

    @DeleteMapping(path = "{fixtureId}")
    public void deleteFixture(@PathVariable int fixtureId) {
        fixtureService.deleteFixture(fixtureId);
    }

    @PostMapping("/")
    public void addFixture(@RequestBody FixtureDTO fixture) {
        fixtureService.addFixture(fixture);
    }

    @PutMapping(path="{fixtureId}")
    public void updateFixture(@PathVariable("fixtureId") int id, @RequestParam(required = false) String homeTeam,
                              @RequestParam(required = false) String awayTeam, @RequestParam(required = false) String kickoff,
                              @RequestParam(required = false) String competition, @RequestParam(required = false) String stadium,
                              @RequestParam(required = false) String skySportsURL) {
        fixtureService.updateFixture(id, homeTeam, awayTeam, kickoff, competition, stadium, skySportsURL);
    }
}

