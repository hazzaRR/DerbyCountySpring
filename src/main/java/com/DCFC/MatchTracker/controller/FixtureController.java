package com.DCFC.MatchTracker.controller;


import com.DCFC.MatchTracker.dto.FixtureDTO;
import com.DCFC.MatchTracker.model.Fixture;
import com.DCFC.MatchTracker.service.FixtureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fixtures/")
public class FixtureController {


    private FixtureService fixtureService;

    public FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "This is Derby County";
    }


//    @GetMapping("/")
//    public List<Fixture> getFixtures() {
//        return fixtureService.getFixtures();
//    }

    @GetMapping(path = "/find")
    public List<Fixture> getFixtures(
            @RequestParam(required = false) String year,
            @RequestParam(required = false) String competition,
            @RequestParam(required = false) String stadium,
            @RequestParam(required = false) String team
    ) {



        if (year != null && competition != null && stadium != null && team != null) {
            return fixtureService.getFixturesByYearAndCompetitionAndStadiumAndTeam(year, competition, stadium, team);
        }
        else if (year != null && competition != null && stadium != null) {
            return fixtureService.getFixturesByYearAndCompetitionAndStadium(year, competition, stadium);
        }
        else if (year != null && competition != null && team != null) {
            return fixtureService.getFixturesByYearAndCompetitionAndTeam(year, competition, team);
        }
        else if (year != null && stadium != null && team != null) {
            return fixtureService.getFixturesByYearAndStadiumAndTeam(year, stadium, team);
        }
        else if (competition != null && stadium != null && team != null) {
            return fixtureService.getFixturesByCompetitionAndStadiumAndTeam(competition, stadium, team);
        }
        else if (year != null && competition != null) {
            return fixtureService.getFixturesByYearAndCompetition(year, competition);
        }
        else if (year != null && stadium != null) {
            return fixtureService.getFixturesByYearAndStadium(year, stadium);
        }
        else if (year != null && team != null) {
            return fixtureService.getFixturesByYearAndTeam(year, team);
        }
        else if (competition != null && stadium != null) {
            return fixtureService.getFixturesByCompetitionAndStadium(competition, stadium);
        }
        else if (competition != null && team != null) {
            return fixtureService.getFixturesByCompetitionAndTeam(competition, team);
        }
        else if (stadium != null && team != null) {
            return fixtureService.getFixturesByStadiumAndTeam(stadium, team);
        }
        else if (year != null) {
            return fixtureService.getFixturesByYear(year);
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

