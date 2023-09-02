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

    @GetMapping("/")
    public String testEndpoint(){
        return "This is Derby County";
    }


    @GetMapping("/all")
    public List<Fixture> getFixtures() {
        return fixtureService.getFixtures();
    }


    @PostMapping("/add")
    public void addFixture(@RequestBody FixtureDTO fixture) {

        fixtureService.addFixture(fixture);

    }
}
