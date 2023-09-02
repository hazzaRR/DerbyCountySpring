package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FixtureRepository extends JpaRepository<Fixture, Integer> {


    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff_date LIKE %?1%", nativeQuery = true)
    List<Fixture> findFixturesByYear(String year);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff_date LIKE %?1% AND competition = ?2 AND stadium = ?3 AND team = ?4",
            nativeQuery = true)
    List<Fixture> findFixturesByYearAndCompetitionAndStadiumAndTeam(String year, String competition, String stadium, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE home_team = ?1 OR away_team = ?1", nativeQuery = true)
    List<Fixture> findFixturesByTeam(String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE stadium = ?1", nativeQuery = true)
    List<Fixture> findFixturesByStadium(String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1", nativeQuery = true)
    List<Fixture> findFixturesByCompetition(String competition);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE stadium = ?1 OR away_team ?2 OR home_team = ?2", nativeQuery = true)
    List<Fixture> findFixturesByStadiumAndTeam(String stadium, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1 OR away_team ?2 OR home_team = ?2", nativeQuery = true)
    List<Fixture> findFixturesByCompetitionAndTeam(String competition, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1 AND stadium ?2", nativeQuery = true)
    List<Fixture> findFixturesByCompetitionAndStadium(String competition, String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE year = ?1 OR away_team ?2 OR home_team = ?2", nativeQuery = true)
    List<Fixture> findFixturesByYearAndTeam(String year, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE year = ?1 AND stadium ?2", nativeQuery = true)
    List<Fixture> findFixturesByYearAndStadium(String year, String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE year = ?1 AND competition ?2", nativeQuery = true)
    List<Fixture> findFixturesByYearAndCompetition(String year, String competition);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE competition = ?1 AND stadium = ?2 OR away_team ?3 OR home_team = ?3", nativeQuery = true)
    List<Fixture> findFixturesByCompetitionAndStadiumAndTeam(String competition, String stadium, String team);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE year = ?1 AND competition = ?2 AND stadium ?3", nativeQuery = true)
    List<Fixture> findFixturesByYearAndCompetitionAndStadium(String year, String competition, String stadium);

    @Query(value = "SELECT * FROM upcoming_fixtures WHERE year = ?1 AND competition = ?2 OR away_team ?3 OR home_team = ?3", nativeQuery = true)
    List<Fixture> findFixturesByYearAndCompetitionAndTeam(String year, String competition, String team);


    @Query(value = "SELECT * FROM upcoming_fixtures WHERE year = ?1 AND stadium = ?2 OR away_team ?3 OR home_team = ?3", nativeQuery = true)
    List<Fixture> findFixturesByYearAndStadiumAndTeam(String year, String stadium, String team);
}