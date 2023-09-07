package com.DCFC.MatchTracker.service;

import com.DCFC.MatchTracker.repository.FixtureRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FixtureServiceTest {

    private FixtureService underTest;

    public FixtureServiceTest (FixtureService fixtureService) {
        this.underTest = fixtureService;
    }





}
