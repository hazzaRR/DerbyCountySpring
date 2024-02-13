package com.DCFC.MatchTracker.controller;


import com.DCFC.MatchTracker.dto.MatchResultDTO;
import com.DCFC.MatchTracker.dto.RecordDTO;
import com.DCFC.MatchTracker.dto.StringResponse;
import com.DCFC.MatchTracker.model.MatchResult;
import com.DCFC.MatchTracker.service.MatchResultService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000", "https://thankful-water-0003d5a03.4.azurestaticapps.net",
        "https://derby-county.harryredman.com"})
@Tag(name = "Match", description = "API to get all the past and present Derby County match results")
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

    @GetMapping(value = "/matches.csv", produces = "text/csv")
    public void getMatchResultsAsCSV(HttpServletResponse response, @RequestParam(required = false) String season, @RequestParam(required = false) String competition,
                                     @RequestParam(required = false) String stadium, @RequestParam(required = false) String team,
                                     @RequestParam(required = false) String result) throws IOException {

        List<MatchResult> matches;

        response.setContentType("text/plain; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=matches.csv");

        // Write CSV header
        StringBuilder csvMatchContent = new StringBuilder();
        csvMatchContent.append("MatchId,HomeTeam,AwayTeam,Kickoff,HomeScore,AwayScore,Result,PenaltiesScore,Season,Competition,Stadium\n");

        if (season != null && competition != null && stadium != null && team != null && result != null) {
            matches =  matchResultService.getMatchResultsBySeasonCompetitionStadiumTeamResult(season, competition, stadium, team, result);
        } else if (season != null && competition != null && stadium != null && team != null) {
            matches =  matchResultService.getMatchResultsBySeasonCompetitionStadiumTeam(season, competition, stadium, team);
        } else if (season != null && competition != null && stadium != null) {
            matches =  matchResultService.getMatchResultsBySeasonCompetitionStadium(season, competition, stadium);
        } else if (season != null && competition != null && team != null) {
            matches =  matchResultService.getMatchResultsBySeasonCompetitionTeam(season, competition, team);
        } else if (season != null && stadium != null && team != null) {
            matches =  matchResultService.getMatchResultsBySeasonStadiumTeam(season, stadium, team);
        } else if (competition != null && stadium != null && team != null) {
            matches =  matchResultService.getMatchResultsByCompetitionStadiumTeam(competition, stadium, team);
        } else if (season != null && competition != null) {
            matches =  matchResultService.getMatchResultsBySeasonCompetition(season, competition);
        } else if (season != null && stadium != null) {
            matches =  matchResultService.getMatchResultsBySeasonStadium(season, stadium);
        } else if (season != null && team != null) {
            matches =  matchResultService.getMatchResultsBySeasonTeam(season, team);
        } else if (competition != null && stadium != null) {
            matches =  matchResultService.getMatchResultsByCompetitionStadium(competition, stadium);
        } else if (competition != null && team != null) {
            matches =  matchResultService.getMatchResultsByCompetitionTeam(competition, team);
        } else if (stadium != null && team != null) {
            matches =  matchResultService.getMatchResultsByStadiumTeam(stadium, team);
        } else if (season != null) {
            matches =  matchResultService.getMatchResultsBySeason(season);
        } else if (competition != null) {
            matches =  matchResultService.getMatchResultsByCompetition(competition);
        } else if (stadium != null) {
            matches =  matchResultService.getMatchResultsByStadium(stadium);
        } else if (team != null) {
            matches =  matchResultService.getMatchResultsByTeam(team);
        } else if (result != null) {
            matches =  matchResultService.getMatchResultsByResult(result);
        } else {
            matches =  matchResultService.getAllMatchResults();
        }

        for (MatchResult match: matches) {
            csvMatchContent.append(match.getMatchId()).append(",")
            .append(match.getHomeTeam()).append(",")
            .append(match.getAwayTeam()).append(",")
            .append(match.getKickoff()).append(",")
            .append(match.getHomeScore()).append(",")
            .append(match.getAwayScore()).append(",")
            .append(match.getResult()).append(",")
            .append(match.getPenaltiesScore()).append(",")
            .append(match.getSeason()).append(",")
            .append(match.getCompetition()).append(",")
            .append(match.getStadium()).append("\n");

        }

        response.getWriter().print(csvMatchContent.toString());



    }

    @GetMapping("/latest-match")
    public MatchResult getLatestResult() {
            return matchResultService.findLatestResult();

    }

    @GetMapping("/all-teams-played-against")
    List<String> teamsPlayedAgainst(@RequestParam(required = false) String season, @RequestParam(required = false) String competition) {

        if (season != null && competition != null) {
            return matchResultService.findTeamsPlayedAgainstBySeasonCompetition(season, competition);
        }
        else if (season != null) {
            return matchResultService.findTeamsPlayedAgainstBySeason(season);
        }
        else if (competition != null) {
            System.out.println(competition);
            return matchResultService.findTeamsPlayedAgainstByCompetition(competition);
        }
        else {
            return matchResultService.findTeamsPlayedAgainst();
        }
    }

    @GetMapping("/seasons")
    List<String> seasonsPlayedIn() {
        return matchResultService.findSeasonsPlayedIn();
    }

    @GetMapping("/competitions")
    List<String> competitionsPlayedIn(@RequestParam(required = false) String season, @RequestParam(required = false) String team) {
        if (season != null && team != null) {
            return matchResultService.findCompetitionsPlayedInBySeasonAndByTeam(season, team);
        }

        if (season != null) {
            return matchResultService.findCompetitionsPlayedInBySeason(season);
        }
        else if (team != null) {
            return matchResultService.findCompetitionsPlayedInByTeam(team);
        }
        return matchResultService.findCompetitionsPlayedIn();
    }

    @GetMapping("/current-season")
    @ResponseBody
    public StringResponse getCurrentSeason() {
        return new StringResponse(matchResultService.getCurrentSeason());
    }
    @GetMapping("/record")
    @ResponseBody
    public List<RecordDTO> getRecord(@RequestParam(required = false) String team) {
        if (team != null) {
            return matchResultService.getRecordByTeam(team);
        }
        return matchResultService.getRecord();
    }
//    @PostMapping("/")
//    public void addMatchResult(@RequestBody MatchResultDTO matchResult) {
//        matchResultService.addMatchResult(matchResult);
//    }
}
