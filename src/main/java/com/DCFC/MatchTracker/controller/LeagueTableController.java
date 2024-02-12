package com.DCFC.MatchTracker.controller;


import com.DCFC.MatchTracker.model.LeagueTable;
import com.DCFC.MatchTracker.service.LeagueTableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/derby-position")
    public Optional<LeagueTable> getDerbyLeaguePosition() {
        return leagueTableService.getDerbyPosition();
    }

    @GetMapping("/position/{id}")
    public Optional<LeagueTable> getTeamInLeaguePosition(@PathVariable("id") int id) {
        return leagueTableService.getLeaguePosition(id);
    }

}
