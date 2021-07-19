package org.focus.teammorale.repository;

import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.focus.teammorale.data.Emotion;
import org.focus.teammorale.data.Team;
import org.focus.teammorale.data.TeamEmotion;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void initDatabase() {
        IndexOptions indexOptions = new IndexOptions();
        indexOptions.unique(true);
        indexOptions.name("XUN_TEAM_NAME");
        mongoCollection().createIndex(Indexes.ascending("teamName"), indexOptions);
    }

    public void init() {
        Team team = new Team();
        team.teamName = "Kyrian";
        team.purpose = "Hacemos realidad tus ideas";
        team.membership = 5;


        TeamEmotion emotion = new TeamEmotion();
        emotion.emotion = Emotion.ALEGRE;
        emotion.registered = LocalDateTime.now();
        emotion.observation = "Ha sido una gran semana";

        Set<TeamEmotion> emotions = new HashSet<>();
        emotions.add(emotion);

        team.teamEmotions = emotions;

        persist(team);

    }
}
