package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixtureRepository extends JpaRepository<Fixture, Integer> {
}