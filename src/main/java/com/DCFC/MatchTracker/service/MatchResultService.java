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

    public List<MatchResult> getMatchResultsBySeasonCompetitionStadiumTeamResult(String season, String competition, String stadium, String team, String result) {
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionStadiumTeam(String season, String competition, String stadium, String team) {
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionStadium(String season, String competition, String stadium) {
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionTeam(String season, String competition, String team) {
    }

    public List<MatchResult> getMatchResultsBySeasonStadiumTeam(String season, String stadium, String team) {
    }

    public List<MatchResult> getMatchResultsByCompetitionStadiumTeam(String competition, String stadium, String team) {
    }

    public List<MatchResult> getMatchResultsBySeasonCompetition(String season, String competition) {
    }

    public List<MatchResult> getMatchResultsBySeasonStadium(String season, String stadium) {
    }

    public List<MatchResult> getMatchResultsBySeasonTeam(String season, String team) {
    }

    public List<MatchResult> getMatchResultsByCompetitionStadium(String competition, String stadium) {
    }

    public List<MatchResult> getMatchResultsByCompetitionTeam(String competition, String team) {
    }

    public List<MatchResult> getMatchResultsByStadiumTeam(String stadium, String team) {
    }

    public List<MatchResult> getMatchResultsBySeason(String season) {
    }

    public List<MatchResult> getMatchResultsByCompetition(String competition) {
    }

    public List<MatchResult> getMatchResultsByStadium(String stadium) {
    }

    public List<MatchResult> getMatchResultsByTeam(String team) {
    }

    public List<MatchResult> getMatchResultsByResult(String result) {
    }

    public List<MatchResult> getAllMatchResults() {
    }
}
