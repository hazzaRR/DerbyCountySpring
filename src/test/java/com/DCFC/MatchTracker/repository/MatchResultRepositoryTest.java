package com.DCFC.MatchTracker.repository;


import com.DCFC.MatchTracker.model.Fixture;
import com.DCFC.MatchTracker.model.MatchResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.registerCustomDateFormat;

@DataJpaTest
public class MatchResultRepositoryTest {

    @Autowired
    private MatchResultRepository underTest;


    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void FindByResult() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByResult("W");

        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);

    }

    @Test
    void FindByResultDoesNotExist() {

        //given

        String teamResult = "W";

        //when

        List<MatchResult> result = underTest.findByResult(teamResult);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindByTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByTeam("Leicester City");

        //then
        assertThat(result).contains(match2);
        assertThat(result).doesNotContain(match1);

    }

    @Test
    void FindByTeamDoesNotExist() {

        //given

        String team = "Norwich City";

        //when

        List<MatchResult> result = underTest.findByResult(team);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindByStadium() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByStadium("Pride Park");

        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);

    }

    @Test
    void FindByStadiumDoesNotExist() {

        //given

        String stadium = "Carrow Road";

        //when

        List<MatchResult> result = underTest.findByStadium(stadium);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindByCompetition() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByCompetition("Championship");

        //then
        assertThat(result).containsAll(matches);

    }

    @Test
    void FindByCompetitionDoesNotExist() {

        //given

        String competition = "Championship";

        //when

        List<MatchResult> result = underTest.findByCompetition(competition);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeason() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeason("2023-24");

        //then
        assertThat(result).containsAll(matches);

    }

    @Test
    void FindBySeasonDoesNotExist() {

        //given

        String season = "2023-24";

        //when

        List<MatchResult> result = underTest.findBySeason(season);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindByStadiumTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByStadiumTeam("Pride Park", "Norwich City");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindByStadiumTeamDoesNotExist() {

        //given

        String stadium = "Pride Park";
        String team = "Norwich";

        //when

        List<MatchResult> result = underTest.findByStadiumTeam(stadium, team);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindByCompetitionTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByCompetitionTeam("Championship", "Norwich City");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindByCompetitionTeamDoesNotExist() {

        //given

        String comp = "Championship";
        String team = "Norwich";

        //when

        List<MatchResult> result = underTest.findByCompetitionTeam(comp, team);

        //then

        assertThat(result).isEmpty();

    }


    @Test
    void FindByCompetitionStadium() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByCompetitionStadium("Championship", "Pride Park");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindByCompetitionStadiumDoesNotExist() {

        //given

        String comp = "Championship";
        String stadium = "Pride Park";

        //when

        List<MatchResult> result = underTest.findByCompetitionStadium(comp, stadium);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonTeam("2023-24", "Norwich City");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindBySeasonTeamDoesNotExist() {

        //given

        String season = "2023-24";
        String team = "Norwich City";

        //when

        List<MatchResult> result = underTest.findBySeasonTeam(season, team);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonStadium() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonStadium("2023-24", "Pride Park");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindBySeasonStadiumDoesNotExist() {

        //given

        String season = "2023-24";
        String stadium = "Pride Park";

        //when

        List<MatchResult> result = underTest.findBySeasonStadium(season, stadium);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonCompetition() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonCompetition("2023-24", "Championship");


        //then
        assertThat(result).containsAll(matches);
    }

    @Test
    void FindBySeasonCompetitionDoesNotExist() {

        //given

        String season = "2023-24";
        String stadium = "Pride Park";

        //when

        List<MatchResult> result = underTest.findBySeasonStadium(season, stadium);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindByCompetitionStadiumTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findByCompetitionStadiumTeam("Championship", "Pride Park", "Norwich City");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindByCompetitionStadiumTeamDoesNotExist() {

        //given

        String competition = "Championship";
        String team = "Norwich City";
        String stadium = "Pride Park";

        //when

        List<MatchResult> result = underTest.findByCompetitionStadiumTeam(competition, stadium, team);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonStadiumTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonStadiumTeam("2023-24", "Pride Park", "Norwich City");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindBySeasonStadiumTeamDoesNotExist() {

        //given

        String season = "2023-24";
        String team = "Norwich City";
        String stadium = "Pride Park";

        //when

        List<MatchResult> result = underTest.findBySeasonStadiumTeam(season, stadium, team);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonCompetitionTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionTeam("2023-24", "Championship", "Norwich City");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindBySeasonCompetitionTeamDoesNotExist() {

        //given

        String season = "2023-24";
        String team = "Norwich City";
        String comp = "Championship";

        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionTeam(season, comp, team);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonCompetitionStadium() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionStadium("2023-24", "Championship", "Pride Park");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindBySeasonCompetitionStadiumDoesNotExist() {

        //given

        String season = "2023-24";
        String stadium = "Pride Park";
        String comp = "Championship";

        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionStadium(season, comp, stadium);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonCompetitionStadiumTeam() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeam("2023-24", "Championship", "Pride Park", "Norwich City");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindBySeasonCompetitionStadiumTeamDoesNotExist() {

        //given

        String season = "2023-24";
        String stadium = "Pride Park";
        String comp = "Championship";
        String team = "Norwich City";

        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeam(season, comp, stadium, team);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindBySeasonCompetitionStadiumTeamResult() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeamResult("2023-24", "Championship", "Pride Park", "Norwich City", "W");


        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);
    }

    @Test
    void FindBySeasonCompetitionStadiumTeamResultDoesNotExist() {

        //given

        String season = "2023-24";
        String stadium = "Pride Park";
        String comp = "Championship";
        String team = "Norwich City";
        String teamResult = "W";

        //when

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeamResult(season, comp, stadium, team, teamResult);

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindTeamsPlayedAgainst() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<String> result = underTest.findTeamsPlayedAgainst();


        //then
        assertThat(result).contains("Norwich City");
        assertThat(result).contains("Leicester City");

    }

    @Test
    void FindTeamsPlayedAgainstDoesNotExist() {

        //given

        //when

        List<String> result = underTest.findTeamsPlayedAgainst();

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindTeamsPlayedAgainstBySeason() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<String> result = underTest.findTeamsPlayedAgainstBySeason("2023-24");


        //then
        assertThat(result).contains("Norwich City");
        assertThat(result).contains("Leicester City");

    }

    @Test
    void FindTeamsPlayedAgainstBySeasonDoesNotExist() {

        //given

        //when

        List<String> result = underTest.findTeamsPlayedAgainstBySeason("2023-24");

        //then

        assertThat(result).isEmpty();

    }
}



