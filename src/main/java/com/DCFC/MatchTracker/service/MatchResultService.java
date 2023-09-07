package com.DCFC.MatchTracker.service;

import com.DCFC.MatchTracker.dto.MatchResultDTO;
import com.DCFC.MatchTracker.model.MatchResult;
import com.DCFC.MatchTracker.repository.MatchResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchResultService {

    private MatchResultRepository matchResultRepository;

    public MatchResultService(MatchResultRepository matchResultRepository) {
        this.matchResultRepository = matchResultRepository;
    }


    public List<MatchResult> findAllMatchResults() {
        return matchResultRepository.findAll();
    }

    public void addMatchResult(MatchResultDTO matchResult) {

        MatchResult newResult = new MatchResult(matchResult.getHomeTeam(), matchResult.getAwayTeam(),
                LocalDateTime.parse(matchResult.getKickoff()), matchResult.getCompetition(), matchResult.getStadium(),
                matchResult.getHomeScore(), matchResult.getAwayScore(), matchResult.getResult(),
                matchResult.getSeason(), matchResult.getPenaltiesScore());

        matchResultRepository.save(newResult);
    }
}
