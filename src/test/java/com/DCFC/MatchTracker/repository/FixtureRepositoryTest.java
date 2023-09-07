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

        underTest.saveAll(fixtures);
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

    @Test
    void findByYearAndCompetitionAndStadiumAndTeam() {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByYearCompetitionStadiumTeam("2023", "Championship", "Pride Park Stadium", "Nottingham Forest");

        //then
        assertThat(result).contains(fixture1);


    }

    @Test
    void findByYearAndCompetitionAndStadiumAndTeamDoesNotExist() {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road Stadium", "https:url123.co.uk");

        //when

        List<Fixture> result = underTest.findFixturesByYearCompetitionStadiumTeam("2023", "Championship", "Pride Park Stadium", "Nottingham Forest");

        //then
        assertThat(result).isEmpty();


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
    void findByYearAndTeam() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByYearTeam("2023", "Nottingham Forest");

        //then
        assertThat(result).contains(fixture1);
        assertThat(result).doesNotContain(fixture2);

    }

    @Test
    void findByYearAndTeamDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByYearTeam("2023", "Nottingham Forest");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByYearAndStadium() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByYearStadium("2023", "Carrow Road");

        //then
        assertThat(result).contains(fixture2);
        assertThat(result).doesNotContain(fixture1);

    }

    @Test
    void findByYearAndStadiumDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByYearStadium("2023", "Pride Park Stadium");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByYearAndCompetition() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByYearCompetition("2023", "Championship");

        //then
        assertThat(result).containsAll(fixtures);

    }

    @Test
    void findByYearAndCompetitionDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByYearCompetition("2023", "Championship");

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
    void findByYearAndCompetitionAndStadium() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByYearCompetitionStadium("2023", "Championship", "Carrow Road");

        //then
        assertThat(result).contains(fixture2);
        assertThat(result).doesNotContain(fixture1);

    }

    @Test
    void findByYearAndCompetitionAndStadiumDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByYearCompetitionStadium("2023", "Championship", "Carrow Road");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByYearAndCompetitionAndTeam() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByYearCompetitionTeam("2023", "Championship", "Norwich City");

        //then
        assertThat(result).contains(fixture2);
        assertThat(result).doesNotContain(fixture1);

    }

    @Test
    void findByYearAndCompetitionAndTeamDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByYearCompetitionTeam("2023", "Championship", "Norwich City");

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void findByYearAndStadiumAndTeam() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture( "Norwich City", "Derby County",  LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        underTest.saveAll(fixtures);
        //when

        List<Fixture> result = underTest.findFixturesByYearStadiumTeam("2023", "Carrow Road", "Norwich City");

        //then
        assertThat(result).contains(fixture2);
        assertThat(result).doesNotContain(fixture1);

    }

    @Test
    void findFixturesByYearAndStadiumAndTeamDoesNotExist() {

        ArrayList<Fixture> fixtures = new ArrayList<>();

        //given
        Fixture fixture1 = new Fixture("Derby County", "Nottingham Forest", LocalDateTime.now(), "Championship", "Pride Park Stadium", "https:url.co.uk");
        Fixture fixture2 = new Fixture("Norwich City", "Derby County", LocalDateTime.now().plusWeeks(2), "Championship", "Carrow Road", "https:url123.co.uk");

        fixtures.add(fixture1);
        fixtures.add(fixture2);

        //when

        List<Fixture> result = underTest.findFixturesByYearStadiumTeam("2023", "Carrow Road", "Norwich City");

        //then
        assertThat(result).isEmpty();

    }
}
