package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchResultRepository extends JpaRepository<MatchResult, Integer> {

    @Query(value = "SELECT DISTINCT(home_team) as team\n" +
            "FROM match_results \n" +
            "WHERE home_team != 'Derby County'\n" +
            "UNION \n" +
            "SELECT away_team as team \n" +
            "FROM match_results \n" +
            "WHERE away_team <> 'Derby County' \n" +
            "ORDER BY team ASC;", nativeQuery = true)
    List<String> findTeamsPlayedAgainst();
    List<MatchResult> findByResult(String result);

    @Query(value = "SELECT * FROM match_results WHERE home_team = ?1 OR away_team = ?1", nativeQuery = true)
    List<MatchResult> findByTeam(String team);

    List<MatchResult> findByStadium(String stadium);

    List<MatchResult> findByCompetition(String competition);

    List<MatchResult> findBySeason(String season);

    @Query(value = "SELECT * FROM match_results WHERE stadium = ?1 AND (home_team = ?2 OR away_team = ?2)", nativeQuery = true)
    List<MatchResult> findByStadiumTeam(String stadium, String team);


    @Query(value = "SELECT * FROM match_results WHERE competition = ?1 AND (home_team = ?2 OR away_team = ?2)", nativeQuery = true)
    List<MatchResult> findByCompetitionTeam(String competition, String team);

    @Query(value = "SELECT * FROM match_results WHERE competition = ?1 AND stadium = ?2", nativeQuery = true)

    List<MatchResult> findByCompetitionStadium(String competition, String stadium);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND (home_team = ?2 OR away_team = ?2)", nativeQuery = true)
    List<MatchResult> findBySeasonTeam(String season, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND stadium = ?2", nativeQuery = true)

    List<MatchResult> findBySeasonStadium(String season, String stadium);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2", nativeQuery = true)

    List<MatchResult> findBySeasonCompetition(String season, String competition);

    @Query(value = "SELECT * FROM match_results WHERE competition = ?1 AND stadium = ?2 AND (home_team = ?3 OR away_team = ?3)", nativeQuery = true)
    List<MatchResult> findByCompetitionStadiumTeam(String competition, String stadium, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND stadium = ?2 AND (home_team = ?3 OR away_team = ?3)", nativeQuery = true)

    List<MatchResult> findBySeasonStadiumTeam(String season, String stadium, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND (home_team = ?3 OR away_team = ?3)", nativeQuery = true)

    List<MatchResult> findBySeasonCompetitionTeam(String season, String competition, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND stadium = ?3", nativeQuery = true)


    List<MatchResult> findBySeasonCompetitionStadium(String season, String competition, String stadium);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND stadium = ?3 AND (home_team = ?4 OR away_team = ?4)", nativeQuery = true)

    List<MatchResult> findBySeasonCompetitionStadiumTeam(String season, String competition, String stadium, String team);

    @Query(value = "SELECT * FROM match_results WHERE season = ?1 AND competition = ?2 AND stadium = ?3 AND (home_team = ?4 OR away_team = ?4) AND result = ?5", nativeQuery = true)

    List<MatchResult> findBySeasonCompetitionStadiumTeamResult(String season, String competition, String stadium, String team, String result);
}
