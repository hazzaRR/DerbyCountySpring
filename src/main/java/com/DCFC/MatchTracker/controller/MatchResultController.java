package com.DCFC.MatchTracker.controller;


import com.DCFC.MatchTracker.dto.MatchResultDTO;
import com.DCFC.MatchTracker.dto.StringResponse;
import com.DCFC.MatchTracker.model.MatchResult;
import com.DCFC.MatchTracker.service.MatchResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/match")
public class MatchResultController {

    private final MatchResultService matchResultService;

    public MatchResultController(MatchResultService matchResultService) {
        this.matchResultService = matchResultService;
    }

    @GetMapping("/find")
public List<MatchResult> getMatchResults(@RequestParam(required = false) String season, @RequestParam(required = false) String competition,
                                         @RequestParam(required = false) String stadium, @RequestParam(required = false) String team,
                                         @RequestParam(required = false) String result) {

        if (season != null && competition != null && stadium != null && team != null && result != null) {
            return matchResultService.getMatchResultsBySeasonCompetitionStadiumTeamResult(season, competition, stadium, team, result);
        } else if (season != null && competition != null && stadium != null && team != null) {
            return matchResultService.getMatchResultsBySeasonCompetitionStadiumTeam(season, competition, stadium, team);
        } else if (season != null && competition != null && stadium != null) {
            return matchResultService.getMatchResultsBySeasonCompetitionStadium(season, competition, stadium);
        } else if (season != null && competition != null && team != null) {
            return matchResultService.getMatchResultsBySeasonCompetitionTeam(season, competition, team);
        } else if (season != null && stadium != null && team != null) {
            return matchResultService.getMatchResultsBySeasonStadiumTeam(season, stadium, team);
        } else if (competition != null && stadium != null && team != null) {
            return matchResultService.getMatchResultsByCompetitionStadiumTeam(competition, stadium, team);
        } else if (season != null && competition != null) {
            return matchResultService.getMatchResultsBySeasonCompetition(season, competition);
        } else if (season != null && stadium != null) {
            return matchResultService.getMatchResultsBySeasonStadium(season, stadium);
        } else if (season != null && team != null) {
            return matchResultService.getMatchResultsBySeasonTeam(season, team);
        } else if (competition != null && stadium != null) {
            return matchResultService.getMatchResultsByCompetitionStadium(competition, stadium);
        } else if (competition != null && team != null) {
            return matchResultService.getMatchResultsByCompetitionTeam(competition, team);
        } else if (stadium != null && team != null) {
            return matchResultService.getMatchResultsByStadiumTeam(stadium, team);
        } else if (season != null) {
            return matchResultService.getMatchResultsBySeason(season);
        } else if (competition != null) {
            return matchResultService.getMatchResultsByCompetition(competition);
        } else if (stadium != null) {
            return matchResultService.getMatchResultsByStadium(stadium);
        } else if (team != null) {
            return matchResultService.getMatchResultsByTeam(team);
        } else if (result != null) {
            return matchResultService.getMatchResultsByResult(result);
        } else {
            return matchResultService.getAllMatchResults();
        }

    }

    @GetMapping("/all-teams-played-against")
    List<String> teamsPlayedAgainst(@RequestParam() String season, @RequestParam(required = false) String competition) {

        if (competition != null) {
            return matchResultService.findTeamsPlayedAgainstBySeasonCompetition(season, competition);
        }
            return matchResultService.findTeamsPlayedAgainstBySeason(season);
    }

    @GetMapping("/seasons")
    List<String> seasonsPlayedIn() {
        return matchResultService.findSeasonsPlayedIn();
    }

    @GetMapping("/competitions")
    List<String> competitionsPlayedIn(@RequestParam(required = false) String season) {
        if (season != null) {
            return matchResultService.findCompetitionsPlayedInBySeason(season);
        }
        return matchResultService.findCompetitionsPlayedIn();
    }

    @PostMapping("/")
    public void addMatchResult(@RequestBody MatchResultDTO matchResult) {
        matchResultService.addMatchResult(matchResult);
    }

    @GetMapping("/current-season")
    @ResponseBody
    public StringResponse getCurrentSeason () {
        return new StringResponse(matchResultService.getCurrentSeason());
    }
}
