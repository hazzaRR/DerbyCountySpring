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
public List<MatchResult> getMatchResults(@RequestParam(required = false) String season,
                                         @RequestParam(required = false) String competition,
                                         @RequestParam(required = false) String stadium,
                                         @RequestParam(required = false) String team,
                                         @RequestParam(required = false) String result) {

        return matchResultService.findAllMatchResults();

    }

    @PostMapping("/")
    public void addMatchResult(@RequestBody MatchResultDTO matchResult) {

        matchResultService.addMatchResult(matchResult);
    }
}
