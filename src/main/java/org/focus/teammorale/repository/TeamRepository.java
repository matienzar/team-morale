package org.focus.teammorale.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.focus.teammorale.data.Emotion;
import org.focus.teammorale.data.Team;
import org.focus.teammorale.data.TeamEmotion;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TeamRepository implements PanacheMongoRepository<Team> {

    public Team findTeam(String teamId, LocalDate start, LocalDate end) {
        List<Team> teamInformation = findAll().list();
        if (teamInformation != null && !teamInformation.isEmpty()) {
            return teamInformation.get(0);
        }
        return null;
    }

    public void reset() {
        deleteAll();
    }

    public void init() {
        Team team = new Team();
        team.teamName = "Kyrian";
        team.purpose = "Hacemos realidad tus ideas";
        team.membership = 5;

        persist(team);

        TeamEmotion emotion = new TeamEmotion();
        emotion.team = team;
        emotion.emotion = Emotion.ALEGRE;
        emotion.registered = LocalDateTime.now();
        emotion.observation = "Ha sido una gran semana";

        List<TeamEmotion> emotions = new ArrayList<>();
        emotions.add(emotion);
        team.teamEmotions = emotions;

        update(team);

    }
}
