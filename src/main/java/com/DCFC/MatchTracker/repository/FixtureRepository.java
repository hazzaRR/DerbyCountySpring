package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FixtureRepository extends JpaRepository<Fixture, Integer> {


    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1%", nativeQuery = true)
    List<Fixture> findFixturesByYear(String year);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1% AND competition = ?2 AND stadium = ?3 AND (home_team = ?4 OR away_team = ?4)",
            nativeQuery = true)
    List<Fixture> findFixturesByYearCompetitionStadiumTeam(String year, String competition, String stadium, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE home_team = ?1 OR away_team = ?1", nativeQuery = true)
    List<Fixture> findFixturesByTeam(String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE stadium = ?1", nativeQuery = true)
    List<Fixture> findFixturesByStadium(String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1", nativeQuery = true)
    List<Fixture> findFixturesByCompetition(String competition);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE stadium = ?1 AND (away_team = ?2 OR home_team = ?2)", nativeQuery = true)
    List<Fixture> findFixturesByStadiumTeam(String stadium, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1 AND (away_team = ?2 OR home_team = ?2)", nativeQuery = true)
    List<Fixture> findFixturesByCompetitionTeam(String competition, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1 AND stadium = ?2", nativeQuery = true)
    List<Fixture> findFixturesByCompetitionStadium(String competition, String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1% AND (away_team = ?2 OR home_team = ?2)", nativeQuery = true)
    List<Fixture> findFixturesByYearTeam(String year, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1% AND stadium = ?2", nativeQuery = true)
    List<Fixture> findFixturesByYearStadium(String year, String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1% AND competition = ?2", nativeQuery = true)
    List<Fixture> findFixturesByYearCompetition(String year, String competition);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1 AND stadium = ?2 AND (away_team = ?3 OR home_team = ?3)", nativeQuery = true)
    List<Fixture> findFixturesByCompetitionStadiumTeam(String competition, String stadium, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1% AND competition = ?2 AND stadium = ?3", nativeQuery = true)
    List<Fixture> findFixturesByYearCompetitionStadium(String year, String competition, String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1% AND competition = ?2 AND (away_team = ?3 OR home_team = ?3)", nativeQuery = true)
    List<Fixture> findFixturesByYearCompetitionTeam(String year, String competition, String team);


    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff LIKE %?1% AND stadium = ?2 AND (away_team = ?3 OR home_team = ?3)", nativeQuery = true)
    List<Fixture> findFixturesByYearStadiumTeam(String year, String stadium, String team);


    @Query(value = "SELECT DISTINCT(competition) from upcoming_fixtures", nativeQuery = true)
    List<String> findCompetitions();

    @Query(value = "SELECT DISTINCT(home_team) as team\n" +
            "FROM upcoming_fixtures \n" +
            "WHERE home_team != 'Derby County' AND competition = ?1\n" +
            "UNION \n" +
            "SELECT away_team as team \n" +
            "FROM upcoming_fixtures \n" +
            "WHERE away_team <> 'Derby County' AND competition = ?1\n" +
            "ORDER BY team ASC;", nativeQuery = true)
    List<String> findTeamsInCompetition(String competition);

    @Query(value = "SELECT DISTINCT(home_team) as team\n" +
            "FROM upcoming_fixtures \n" +
            "WHERE home_team != 'Derby County'\n" +
            "UNION \n" +
            "SELECT away_team as team \n" +
            "FROM upcoming_fixtures \n" +
            "WHERE away_team <> 'Derby County'\n" +
            "ORDER BY team ASC;", nativeQuery = true)
    List<String> findTeams();


}