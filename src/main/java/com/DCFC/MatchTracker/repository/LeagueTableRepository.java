package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.LeagueTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeagueTableRepository extends JpaRepository<LeagueTable, String> {

    Optional<LeagueTable> findLeagueTableByLeaguePosition(int position);
}
