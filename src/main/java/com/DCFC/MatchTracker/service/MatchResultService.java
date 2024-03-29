package com.DCFC.MatchTracker.service;

import com.DCFC.MatchTracker.dto.MatchResultDTO;
import com.DCFC.MatchTracker.dto.RecordDTO;
import com.DCFC.MatchTracker.model.MatchResult;
import com.DCFC.MatchTracker.repository.MatchResultRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        return matchResultRepository.findBySeasonCompetitionStadiumTeamResultOrderByKickoffDesc(season,competition, stadium, team, result);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionStadiumTeam(String season, String competition, String stadium, String team) {
        return matchResultRepository.findBySeasonCompetitionStadiumTeamOrderByKickoffDesc(season,competition, stadium, team);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionStadium(String season, String competition, String stadium) {
        return matchResultRepository.findBySeasonCompetitionStadiumOrderByKickoffDesc(season,competition, stadium);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetitionTeam(String season, String competition, String team) {
        return matchResultRepository.findBySeasonCompetitionTeamOrderByKickoffDesc(season,competition, team);
    }

    public List<MatchResult> getMatchResultsBySeasonStadiumTeam(String season, String stadium, String team) {
        return matchResultRepository.findBySeasonStadiumTeamOrderByKickoffDesc(season,stadium, team);
    }

    public List<MatchResult> getMatchResultsByCompetitionStadiumTeam(String competition, String stadium, String team) {
        return matchResultRepository.findByCompetitionStadiumTeamOrderByKickoffDesc(competition,stadium, team);
    }

    public List<MatchResult> getMatchResultsBySeasonCompetition(String season, String competition) {
        return matchResultRepository.findBySeasonCompetitionOrderByKickoffDesc(season,competition);
    }

    public List<MatchResult> getMatchResultsBySeasonStadium(String season, String stadium) {
        return matchResultRepository.findBySeasonStadiumOrderByKickoffDesc(season,stadium);
    }

    public List<MatchResult> getMatchResultsBySeasonTeam(String season, String team) {
        return matchResultRepository.findBySeasonTeamOrderByKickoffDesc(season,team);
    }

    public List<MatchResult> getMatchResultsByCompetitionStadium(String competition, String stadium) {
        return matchResultRepository.findByCompetitionStadiumOrderByKickoffDesc(competition,stadium);
    }

    public List<MatchResult> getMatchResultsByCompetitionTeam(String competition, String team) {
        return matchResultRepository.findByCompetitionTeamOrderByKickoffDesc(competition,team);
    }

    public List<MatchResult> getMatchResultsByStadiumTeam(String stadium, String team) {
        return matchResultRepository.findByStadiumTeamOrderByKickoffDesc(stadium,team);
    }

    public List<MatchResult> getMatchResultsBySeason(String season) {
        return matchResultRepository.findBySeasonOrderByKickoffDesc(season);
    }

    public List<MatchResult> getMatchResultsByCompetition(String competition) {
        return matchResultRepository.findByCompetitionOrderByKickoffDesc(competition);
    }

    public List<MatchResult> getMatchResultsByStadium(String stadium) {
        return matchResultRepository.findByStadiumOrderByKickoffDesc(stadium);
    }

    public List<MatchResult> getMatchResultsByTeam(String team) {
        return matchResultRepository.findByTeamOrderByKickoffDesc(team);
    }

    public List<MatchResult> getMatchResultsByResult(String result) {
        return matchResultRepository.findByResultOrderByKickoffDesc(result);
    }

    public List<MatchResult> getAllMatchResults() {
        return matchResultRepository.findAll(Sort.by(Sort.Direction.DESC, "kickoff"));
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

    public List<RecordDTO> getRecordByTeam(String team) {
        return matchResultRepository.findRecordByTeam(team);
    }

    public MatchResult findLatestResult() {
        return  matchResultRepository.findLatestResult();
    }
}
