package com.DCFC.MatchTracker.controller;


import com.DCFC.MatchTracker.dto.MatchResultDTO;
import com.DCFC.MatchTracker.model.MatchResult;
import com.DCFC.MatchTracker.service.MatchResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match/")
public class MatchResultController {

    private MatchResultService matchResultService;

    public MatchResultController(MatchResultService matchResultService) {
        this.matchResultService = matchResultService;
    }

    @GetMapping("/")
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

    @PostMapping("/")
    public void addMatchResult(@RequestBody MatchResultDTO matchResult) {

        matchResultService.addMatchResult(matchResult);
    }
}
