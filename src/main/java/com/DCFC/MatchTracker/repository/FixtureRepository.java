package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FixtureRepository extends JpaRepository<Fixture, Integer> {


    @Query(value = "SELECT * FROM upcoming_fixtures WHERE kickoff_date LIKE %?1%", nativeQuery = true)
    List<Fixture> findFixturesByYear(String year);
}