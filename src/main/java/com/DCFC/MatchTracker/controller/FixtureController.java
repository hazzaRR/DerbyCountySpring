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


    @GetMapping("/")
    public List<Fixture> getFixtures() {
        return fixtureService.getFixtures();
    }

    @GetMapping(name = "/", params = {"year", "competition", "location", "team"})
    public List<Fixture> getFixtures(
            @RequestParam(name = "year", required = false) String year,
            @RequestParam(name = "competition", required = false) String competition,
            @RequestParam(name = "stadium", required = false) String stadium,
            @RequestParam(name = "team", required = false) String team
    ) {

        if (year != null && competition != null && stadium != null && team != null) {
            return fixtureService.getFixturesByYearAndCompetitionAndStadiumAndTeam(year, competition, stadium, team);
        }

        else {
            return fixtureService.getFixturesByYear(year);
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
}

