package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.Fixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FixtureRepositoryTest {

    @Autowired
    private FixtureRepository underTest;


    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByTeamHome() {


        //given
        Fixture fixture = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");


        underTest.save(fixture);
        //when

        List<Fixture> result = underTest.findFixturesByTeam("Norwich City");

        //then
        assertThat(result).contains(fixture);


    }

    @Test
    void findByTeamAway() {


        //given
        Fixture fixture = new Fixture("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");


        underTest.save(fixture);
        //when

        List<Fixture> result = underTest.findFixturesByTeam("Norwich City");

        //then
        assertThat(result).contains(fixture);


    }

    @Test
    void findByTeamDoesNotExist() {


        //given
        Fixture fixture = new Fixture("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        //when

        List<Fixture> result = underTest.findFixturesByTeam("Norwich City");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByStadium() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByStadium("Pride Park Stadium");

        //then
        assertThat(result).contains(fixture1);

    }


    @Test
    void findByStadiumDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        //when

        List<Fixture> result = underTest.findFixturesByStadium("Pride Park Stadium");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByCompetition() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByCompetition("Championship");

        //then
        assertThat(result).containsAll(fixtures);

    }

    @Test
    void findByCompetitionDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByCompetition("Championship");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByStadiumAndTeam() {


        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Derby County", "Norwich City",  LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByStadiumTeam("Pride Park Stadium", "Nottingham Forest");

        //then
        assertThat(result).contains(fixture1);
        assertThat(result).doesNotContain(fixture2);

    }

    @Test
    void findByStadiumAndTeamDoesNotExist() {


        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Derby County", "Norwich City",  LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByStadiumTeam("Pride Park Stadium", "Nottingham Forest");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByCompetitionAndTeam() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByCompetitionTeam("Championship", "Norwich City");

        //then
        assertThat(result).contains(fixture2);
        assertThat(result).doesNotContain(fixture1);

    }

    @Test
    void findByCompetitionAndTeamDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByCompetitionTeam("Championship", "Norwich City");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByCompetitionAndStadium() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByCompetitionStadium("Championship", "Pride Park Stadium");

        //then
        assertThat(result).contains(fixture1);
        assertThat(result).doesNotContain(fixture2);

    }

    @Test
    void findByCompetitionAndStadiumDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByCompetitionStadium("Championship", "Pride Park Stadium");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByCompetitionAndStadiumAndTeam() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByCompetitionStadiumTeam("Championship", "Carrow Road", "Norwich City");

        //then
        assertThat(result).contains(fixture2);
        assertThat(result).doesNotContain(fixture1);

    }

    @Test
    void findByCompetitionAndStadiumAndTeamDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByCompetitionStadiumTeam("Championship", "Carrow Road", "Norwich City");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void FindNextFixture() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        Fixture result = underTest.findNextFixture();

        //then
        assertThat(result).isEqualTo(fixture1);

    }

    @Test
    void FindNextFixtureDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        Fixture result = underTest.findNextFixture();

        //then
        assertThat(result).isNull();

    }
}
