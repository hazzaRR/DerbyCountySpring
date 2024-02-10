package com.DCFC.MatchTracker.repository;


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

        List<MatchResult> result = underTest.findByResultOrderByKickoffDesc("W");

        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);

    }

    @Test
    void FindByResultDoesNotExist() {

        //given

        String teamResult = "W";

        //when

        List<MatchResult> result = underTest.findByResultOrderByKickoffDesc(teamResult);

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

        List<MatchResult> result = underTest.findByTeamOrderByKickoffDesc("Leicester City");

        //then
        assertThat(result).contains(match2);
        assertThat(result).doesNotContain(match1);

    }

    @Test
    void FindByTeamDoesNotExist() {

        //given

        String team = "Norwich City";

        //when

        List<MatchResult> result = underTest.findByResultOrderByKickoffDesc(team);

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

        List<MatchResult> result = underTest.findByStadiumOrderByKickoffDesc("Pride Park");

        //then
        assertThat(result).contains(match1);
        assertThat(result).doesNotContain(match2);

    }

    @Test
    void FindByStadiumDoesNotExist() {

        //given

        String stadium = "Carrow Road";

        //when

        List<MatchResult> result = underTest.findByStadiumOrderByKickoffDesc(stadium);

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

        List<MatchResult> result = underTest.findByCompetitionOrderByKickoffDesc("Championship");

        //then
        assertThat(result).containsAll(matches);

    }

    @Test
    void FindByCompetitionDoesNotExist() {

        //given

        String competition = "Championship";

        //when

        List<MatchResult> result = underTest.findByCompetitionOrderByKickoffDesc(competition);

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

        List<MatchResult> result = underTest.OrderByKickoffDesc("2023-24");

        //then
        assertThat(result).containsAll(matches);

    }

    @Test
    void FindBySeasonDoesNotExist() {

        //given

        String season = "2023-24";

        //when

        List<MatchResult> result = underTest.OrderByKickoffDesc(season);

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

        List<MatchResult> result = underTest.findByStadiumTeamOrderByKickoffDesc("Pride Park", "Norwich City");


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

        List<MatchResult> result = underTest.findByStadiumTeamOrderByKickoffDesc(stadium, team);

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

        List<MatchResult> result = underTest.findByCompetitionTeamOrderByKickoffDesc("Championship", "Norwich City");


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

        List<MatchResult> result = underTest.findByCompetitionTeamOrderByKickoffDesc(comp, team);

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

        List<MatchResult> result = underTest.findByCompetitionStadiumOrderByKickoffDesc("Championship", "Pride Park");


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

        List<MatchResult> result = underTest.findByCompetitionStadiumOrderByKickoffDesc(comp, stadium);

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

        List<MatchResult> result = underTest.findBySeasonTeamOrderByKickoffDesc("2023-24", "Norwich City");


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

        List<MatchResult> result = underTest.findBySeasonTeamOrderByKickoffDesc(season, team);

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

        List<MatchResult> result = underTest.findBySeasonStadiumOrderByKickoffDesc("2023-24", "Pride Park");


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

        List<MatchResult> result = underTest.findBySeasonStadiumOrderByKickoffDesc(season, stadium);

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

        List<MatchResult> result = underTest.findBySeasonCompetitionOrderByKickoffDesc("2023-24", "Championship");


        //then
        assertThat(result).containsAll(matches);
    }

    @Test
    void FindBySeasonCompetitionDoesNotExist() {

        //given

        String season = "2023-24";
        String stadium = "Pride Park";

        //when

        List<MatchResult> result = underTest.findBySeasonStadiumOrderByKickoffDesc(season, stadium);

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

        List<MatchResult> result = underTest.findByCompetitionStadiumTeamOrderByKickoffDesc("Championship", "Pride Park", "Norwich City");


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

        List<MatchResult> result = underTest.findByCompetitionStadiumTeamOrderByKickoffDesc(competition, stadium, team);

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

        List<MatchResult> result = underTest.findBySeasonStadiumTeamOrderByKickoffDesc("2023-24", "Pride Park", "Norwich City");


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

        List<MatchResult> result = underTest.findBySeasonStadiumTeamOrderByKickoffDesc(season, stadium, team);

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

        List<MatchResult> result = underTest.findBySeasonCompetitionTeamOrderByKickoffDesc("2023-24", "Championship", "Norwich City");


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

        List<MatchResult> result = underTest.findBySeasonCompetitionTeamOrderByKickoffDesc(season, comp, team);

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

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumOrderByKickoffDesc("2023-24", "Championship", "Pride Park");


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

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumOrderByKickoffDesc(season, comp, stadium);

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

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeamOrderByKickoffDesc("2023-24", "Championship", "Pride Park", "Norwich City");


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

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeamOrderByKickoffDesc(season, comp, stadium, team);

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

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeamResultOrderByKickoffDesc("2023-24", "Championship", "Pride Park", "Norwich City", "W");


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

        List<MatchResult> result = underTest.findBySeasonCompetitionStadiumTeamResultOrderByKickoffDesc(season, comp, stadium, team, teamResult);

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

    @Test
    void FindSeasonsPlayedIn() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2022-23", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<String> result = underTest.findSeasonsPlayedIn();


        //then
        assertThat(result).contains("2023-24");
        assertThat(result).contains("2022-23");

    }

    @Test
    void FindSeasonsPlayedInDoesNotExist() {

        //given

        //when

        List<String> result = underTest.findSeasonsPlayedIn();

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindCompetitionsPlayedIn() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2022-23", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<String> result = underTest.findCompetitionsPlayedIn();


        //then
        assertThat(result).contains("Championship");

    }

    @Test
    void FindCompetitionsPlayedInDoesNotExist() {

        //given

        //when

        List<String> result = underTest.findCompetitionsPlayedIn();

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindCompetitionsPlayedInBySeason() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2022-23", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<String> result = underTest.findCompetitionsPlayedInBySeason("2023-24");


        //then
        assertThat(result).contains("Championship");

    }

    @Test
    void FindCompetitionsPlayedInBySeasonDoesNotExist() {

        //given

        //when

        List<String> result = underTest.findCompetitionsPlayedInBySeason("2023-24");

        //then

        assertThat(result).isEmpty();

    }

    @Test
    void FindCurrentSeason() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2022-23", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        String result = underTest.findCurrentSeason();


        //then
        assertThat(result).isEqualTo("2023-24");


    }

    @Test
    void FindCurrentSeasonDoesNotExist() {

        //given

        //when

        String result = underTest.findCurrentSeason();

        System.out.println(result);

        //then

        assertThat(result).isNull();

    }

    @Test
    void FindTeamsPlayedAgainstBySeasonCompetition() {

        ArrayList<MatchResult> matches = new ArrayList<>();

        //given
        MatchResult match1 = new MatchResult("Derby County", "Norwich City", LocalDateTime.now().plusWeeks(2), "Championship", "Pride Park", 2, 1, "W", "2023-24", null);
        MatchResult match2 = new MatchResult("Derby County", "Leicester City", LocalDateTime.now(), "Championship", "King Power Stadium", 2, 3, "L", "2023-24", null);

        matches.add(match1);
        matches.add(match2);

        underTest.saveAll(matches);
        //when

        List<String> result = underTest.findTeamsPlayedAgainstBySeasonCompetition("2023-24", "Championship");


        //then
        assertThat(result).contains("Norwich City");
        assertThat(result).contains("Leicester City");


    }

    @Test
    void FindTeamsPlayedAgainstBySeasonCompetitionDoesNotExist() {

        //given

        //when

        String result = underTest.findCurrentSeason();

        System.out.println(result);

        //then

        assertThat(result).isNull();

    }
}



