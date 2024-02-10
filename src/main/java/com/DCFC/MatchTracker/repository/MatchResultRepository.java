package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.dto.RecordDTO;
import com.DCFC.MatchTracker.model.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchResultRepository extends JpaRepository<MatchResult, Integer> {

    List<MatchResult> findByResultOrderByKickoffDesc(String result);

    @Query(value = "SELECT * FROM match_results WHERE home_team = ?1 OR away_team = ?1 ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findByTeamOrderByKickoffDesc(String team);

    List<MatchResult> findByStadiumOrderByKickoffDesc(String stadium);

    List<MatchResult> findByCompetitionOrderByKickoffDesc(String competition);

    List<MatchResult> findBySeasonOrderByKickoffDesc(String season);

    @Query(value = "SELECT * FROM match_results WHERE stadium = ?1 AND (home_team = ?2 OR away_team = ?2) ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findByStadiumTeamOrderByKickoffDesc(String stadium, String team);


    @Query(value = "SELECT * FROM match_results WHERE competition = ?1 AND (home_team = ?2 OR away_team = ?2) ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findByCompetitionTeamOrderByKickoffDesc(String competition, String team);

    @Query(value = "SELECT * FROM match_results WHERE competition = ?1 AND stadium = ?2 ORDER BY kickoff DESC", nativeQuery = true)

    List<MatchResult> findByCompetitionStadiumOrderByKickoffDesc(String competition, String stadium);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND (home_team = ?2 OR away_team = ?2) ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonTeamOrderByKickoffDesc(String season, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND stadium = ?2 ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonStadiumOrderByKickoffDesc(String season, String stadium);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonCompetitionOrderByKickoffDesc(String season, String competition);

    @Query(value = "SELECT * FROM match_results WHERE competition = ?1 AND stadium = ?2 AND (home_team = ?3 OR away_team = ?3) ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findByCompetitionStadiumTeamOrderByKickoffDesc(String competition, String stadium, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND stadium = ?2 AND (home_team = ?3 OR away_team = ?3) ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonStadiumTeamOrderByKickoffDesc(String season, String stadium, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND (home_team = ?3 OR away_team = ?3) ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonCompetitionTeamOrderByKickoffDesc(String season, String competition, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND stadium = ?3 ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonCompetitionStadiumOrderByKickoffDesc(String season, String competition, String stadium);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND stadium = ?3 AND (home_team = ?4 OR away_team = ?4) ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonCompetitionStadiumTeamOrderByKickoffDesc(String season, String competition, String stadium, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND stadium = ?3 AND (home_team = ?4 OR away_team = ?4) AND result = ?5 ORDER BY kickoff DESC", nativeQuery = true)
    List<MatchResult> findBySeasonCompetitionStadiumTeamResultOrderByKickoffDesc(String season, String competition, String stadium, String team, String result);

    @Query(value = "SELECT DISTINCT(home_team) as team\n" +
            "FROM match_results \n" +
            "WHERE home_team != 'Derby County'\n" +
            "UNION \n" +
            "SELECT away_team as team \n" +
            "FROM match_results \n" +
            "WHERE away_team <> 'Derby County' \n" +
            "ORDER BY team ASC;", nativeQuery = true)
    List<String> findTeamsPlayedAgainst();

    @Query(value = "SELECT DISTINCT(home_team) as team\n" +
            "FROM match_results \n" +
            "WHERE home_team != 'Derby County' AND season = ?1\n" +
            "UNION \n" +
            "SELECT away_team as team \n" +
            "FROM match_results \n" +
            "WHERE away_team <> 'Derby County'  AND season = ?1\n" +
            "ORDER BY team ASC;", nativeQuery = true)
    List<String> findTeamsPlayedAgainstBySeason(String season);

    @Query(value = "SELECT DISTINCT(season) from match_results ORDER BY season DESC;", nativeQuery = true)
    List<String> findSeasonsPlayedIn();

    @Query(value = "SELECT DISTINCT(competition) from match_results;", nativeQuery = true)
    List<String> findCompetitionsPlayedIn();

    @Query(value = "SELECT DISTINCT(competition) from match_results WHERE season = ?1", nativeQuery = true)
    List<String> findCompetitionsPlayedInBySeason(String season);

    @Query(value = "SELECT DISTINCT(competition)\n" +
            "FROM match_results \n" +
            "WHERE home_team = ?1\n" +
            "UNION \n" +
            "SELECT DISTINCT(competition)\n" +
            "FROM match_results \n" +
            "WHERE away_team = ?1 \n", nativeQuery = true)
    List<String> findCompetitionsPlayedInByTeam(String team);


    @Query(value = "SELECT DISTINCT(competition)\n" +
            "FROM match_results \n" +
            "WHERE home_team = ?2 AND season = ?1\n" +
            "UNION \n" +
            "SELECT DISTINCT(competition)\n" +
            "FROM match_results \n" +
            "WHERE away_team = ?2 AND season = ?1\n", nativeQuery = true)
    List<String> findCompetitionsPlayedInBySeasonAndByTeam(String season, String team);


    @Query(value = "SELECT season from match_results ORDER BY season DESC LIMIT 1", nativeQuery = true)
    String findCurrentSeason();

    @Query(value = "SELECT DISTINCT(home_team) as team\n" +
            "FROM match_results \n" +
            "WHERE home_team != 'Derby County' AND season = ?1 AND competition = ?2\n" +
            "UNION \n" +
            "SELECT away_team as team \n" +
            "FROM match_results \n" +
            "WHERE away_team <> 'Derby County'  AND season = ?1 AND competition = ?2\n" +
            "ORDER BY team ASC;", nativeQuery = true)
    List<String> findTeamsPlayedAgainstBySeasonCompetition(String season, String competition);


    @Query(value = "SELECT DISTINCT(home_team) as team\n" +
            "FROM match_results \n" +
            "WHERE home_team != 'Derby County' AND competition = ?1\n" +
            "UNION \n" +
            "SELECT away_team as team \n" +
            "FROM match_results \n" +
            "WHERE away_team <> 'Derby County' AND competition = ?1\n" +
            "ORDER BY team ASC;", nativeQuery = true)
    List<String> findTeamsPlayedAgainstByCompetition(String competition);


    @Query(value = "SELECT new com.DCFC.MatchTracker.dto.RecordDTO(result, count(*)) from MatchResult GROUP BY result")
    List<RecordDTO> findRecord();

    @Query(value = "SELECT new com.DCFC.MatchTracker.dto.RecordDTO(m.result, count(*)) from MatchResult m WHERE m.homeTeam = ?1 OR m.awayTeam = ?1 GROUP BY m.result")
    List<RecordDTO> findRecordByTeam(String team);

    @Query(value = "SELECT * FROM match_results ORDER BY kickoff DESC LIMIT 1", nativeQuery = true)
    MatchResult findLatestResult();
}
