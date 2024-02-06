package com.DCFC.MatchTracker.service;

import com.DCFC.MatchTracker.dto.MatchResultDTO;
import com.DCFC.MatchTracker.dto.RecordDTO;
import com.DCFC.MatchTracker.model.MatchResult;
import com.DCFC.MatchTracker.repository.MatchResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class MatchResultService {

    private final MatchResultRepository matchResultRepository;

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
        return matchResultRepository.findBySeasonCompetitionStadiumTeamResult(season,competition, stadium, team, result);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionStadiumTeam(String season, String competition, String stadium, String team) {
        return matchResultRepository.findBySeasonCompetitionStadiumTeam(season,competition, stadium, team);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionStadium(String season, String competition, String stadium) {
        return matchResultRepository.findBySeasonCompetitionStadium(season,competition, stadium);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionTeam(String season, String competition, String team) {
        return matchResultRepository.findBySeasonCompetitionTeam(season,competition, team);
    }

    public List<MatchResult> getMatchResultsBySeasonStadiumTeam(String season, String stadium, String team) {
        return matchResultRepository.findBySeasonStadiumTeam(season,stadium, team);
    }

    public List<MatchResult> getMatchResultsByCompetitionStadiumTeam(String competition, String stadium, String team) {
        return matchResultRepository.findByCompetitionStadiumTeam(competition,stadium, team);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetition(String season, String competition) {
        return matchResultRepository.findBySeasonCompetition(season,competition);
    }

    public List<MatchResult> getMatchResultsBySeasonStadium(String season, String stadium) {
        return matchResultRepository.findBySeasonStadium(season,stadium);
    }

    public List<MatchResult> getMatchResultsBySeasonTeam(String season, String team) {
        return matchResultRepository.findBySeasonTeam(season,team);
    }

    public List<MatchResult> getMatchResultsByCompetitionStadium(String competition, String stadium) {
        return matchResultRepository.findByCompetitionStadium(competition,stadium);
    }

    public List<MatchResult> getMatchResultsByCompetitionTeam(String competition, String team) {
        return matchResultRepository.findByCompetitionTeam(competition,team);
    }

    public List<MatchResult> getMatchResultsByStadiumTeam(String stadium, String team) {
        return matchResultRepository.findByStadiumTeam(stadium,team);
    }

    public List<MatchResult> getMatchResultsBySeason(String season) {
        return matchResultRepository.findBySeason(season);
    }

    public List<MatchResult> getMatchResultsByCompetition(String competition) {
        return matchResultRepository.findByCompetition(competition);
    }

    public List<MatchResult> getMatchResultsByStadium(String stadium) {
        return matchResultRepository.findByStadium(stadium);
    }

    public List<MatchResult> getMatchResultsByTeam(String team) {
        return matchResultRepository.findByTeam(team);
    }

    public List<MatchResult> getMatchResultsByResult(String result) {
        return matchResultRepository.findByResult(result);
    }

    public List<MatchResult> getAllMatchResults() {
        return matchResultRepository.findAll();
    }

    public List<String> findTeamsPlayedAgainst() {
        return matchResultRepository.findTeamsPlayedAgainst();
    }

    public List<String> findTeamsPlayedAgainstBySeason(String season) {
        return matchResultRepository.findTeamsPlayedAgainstBySeason(season);
    }

    public List<String> findSeasonsPlayedIn() {
        return  matchResultRepository.findSeasonsPlayedIn();
    }

    public List<String> findCompetitionsPlayedIn() {
        return matchResultRepository.findCompetitionsPlayedIn();
    }

    public List<String> findCompetitionsPlayedInBySeason(String season) {
        return matchResultRepository.findCompetitionsPlayedInBySeason(season);
    }
    public List<String> findCompetitionsPlayedInByTeam(String team) {
        return matchResultRepository.findCompetitionsPlayedInByTeam(team);
    }

    public String getCurrentSeason() {
        return matchResultRepository.findCurrentSeason();
    }

    public List<String> findTeamsPlayedAgainstBySeasonCompetition(String season, String competition) {
        return matchResultRepository.findTeamsPlayedAgainstBySeasonCompetition(season, competition);
    }

    public List<String> findTeamsPlayedAgainstByCompetition(String competition) {
        return matchResultRepository.findTeamsPlayedAgainstByCompetition(competition);
    }

    public List<String> findCompetitionsPlayedInBySeasonAndByTeam(String season, String team) {
        return matchResultRepository.findCompetitionsPlayedInBySeasonAndByTeam(season, team);
    }

    public List<RecordDTO>  getRecord() {
        return matchResultRepository.findRecord();
    }
}
