package com.DCFC.MatchTracker.controller;


import com.DCFC.MatchTracker.model.LeagueTable;
import com.DCFC.MatchTracker.service.LeagueTableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000", "https://thankful-water-0003d5a03.4.azurestaticapps.net",
        "https://derby-county.harryredman.com"})
@Tag(name = "League Table", description = "API to get all the data for the current seasons league table Derby County are competing in domestically")
@RestController
@RequestMapping("/api/league-table")
public class LeagueTableController {


    private final LeagueTableService leagueTableService;


    public LeagueTableController(LeagueTableService leagueTableService) {
        this.leagueTableService = leagueTableService;
    }

    @GetMapping("/")
    public List<LeagueTable> getLeagueTable() {
        return leagueTableService.getLeagueTable();
    }



}
