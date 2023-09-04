package com.DCFC.MatchTracker.service;

import com.DCFC.MatchTracker.model.MatchResult;
import com.DCFC.MatchTracker.repository.MatchResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchResultService {

    private MatchResultRepository matchResultRepository;

    public MatchResultService(MatchResultRepository matchResultRepository) {
        this.matchResultRepository = matchResultRepository;
    }


    public List<MatchResult> findAllMatchResults() {
        return matchResultRepository.findAll();
    }
}
