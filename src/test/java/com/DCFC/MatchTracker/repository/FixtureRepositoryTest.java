package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.Fixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FixtureRepositoryTest {

    @Autowired
    private FixtureRepository underTest;

//    public FixtureRepositoryTest (FixtureRepository fixtureRepository) {
//        this.underTest = fixtureRepository;
//    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }


    @Test
    void FindByYear() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.save(fixture1);
        underTest.save(fixture2);
        //when

        List<Fixture> result = underTest.findFixturesByYear("2023");

        //then
        assertThat(result).containsAll(fixtures);

    }

    @Test
    void FindByYearWhichDoesNotExist() {

        //given

        String year = "2023";

        //when

        List<Fixture> result = underTest.findFixturesByYear(year);

        //then

        assertThat(result).isEmpty();

    }
}
