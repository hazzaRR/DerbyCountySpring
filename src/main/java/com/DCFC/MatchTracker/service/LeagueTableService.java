package com.DCFC.MatchTracker.service;


import com.DCFC.MatchTracker.model.LeagueTable;
import com.DCFC.MatchTracker.repository.LeagueTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueTableService {

    private final LeagueTableRepository leagueTableRepository;


    public LeagueTableService(LeagueTableRepository leagueTableRepository) {
        this.leagueTableRepository = leagueTableRepository;
    }
    public List<LeagueTable> getLeagueTable() {
        return leagueTableRepository.findAll();
    }

    public Optional<LeagueTable> getDerbyPosition() {
        return leagueTableRepository.findById("Derby County");
    }
}
