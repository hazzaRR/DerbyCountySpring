package com.DCFC.MatchTracker.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = {"http://localhost:3000", "https://thankful-water-0003d5a03.4.azurestaticapps.net",
        "https://derby-county.harryredman.com"})
@Tag(name = "League Table", description = "API to get all the data for the current seasons league table Derby County are competing in domestically")
@RestController
@RequestMapping("/api/league-table")
public class LeagueTableController {


}
