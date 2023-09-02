package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchResultRepository extends JpaRepository<MatchResult, Integer> {
}
