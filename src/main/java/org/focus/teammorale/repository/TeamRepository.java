package org.focus.teammorale.repository;

import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.focus.teammorale.data.Emotion;
import org.focus.teammorale.data.EmotionLevel;
import org.focus.teammorale.data.Team;
import org.focus.teammorale.data.TeamEmotion;
import org.focus.teammorale.dto.MoraleEmotion;
import org.focus.teammorale.dto.TeamMorale;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamRepository implements PanacheMongoRepository<Team> {

    public TeamMorale findTeam(String teamId, LocalDate from, LocalDate to) {

        // Group by emotion
        List<Team> teamInformation = findAll().list();
        if (teamInformation != null && !teamInformation.isEmpty()) {
            Team team = teamInformation.get(0);

            TeamMorale morale = new TeamMorale();
            morale.setFrom(from);
            morale.setTo(to);

            // Emotions on this period
            List<MoraleEmotion> emotions = team.teamEmotions.stream()
                    .collect(
                            Collectors.groupingBy(TeamEmotion::getEmotion, Collectors.counting())
                    ).entrySet().stream()
                    .map(e -> new MoraleEmotion(e.getKey(), e.getValue())).collect(Collectors.toList());
            morale.setEmotions(emotions);

            // Group emotions by level
            List<Long> emotionsByLevel = new ArrayList<>();
            for (EmotionLevel level : EmotionLevel.values()) {
                Map<EmotionLevel, Long> emotionByLevel =
                        team.teamEmotions
                                .stream()
                                .map(TeamEmotion::getEmotion)
                                .collect(Collectors.groupingBy(emotion -> emotion.level, Collectors.counting()));
                emotionsByLevel.add(emotionByLevel.get(level) == null ? 0L : emotionByLevel.get(level));
            }
            morale.setEmotionsByLevel(emotionsByLevel);

            // Search max peak of emotion on period
            morale.setMaxOnPeriod(
                    emotions.stream().mapToLong(MoraleEmotion::getTotalOnPeriod).max().orElse(0L)
            );

            return morale;
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

        Set<TeamEmotion> emotions = new HashSet<>();
        TeamEmotion emotion = new TeamEmotion();
        emotion.emotion = Emotion.ALEGRE;
        emotion.registered = LocalDateTime.now();
        emotion.observation = "Ha sido una gran semana";
        emotions.add(emotion);

        emotion = new TeamEmotion();
        emotion.emotion = Emotion.ALEGRE;
        emotion.registered = LocalDateTime.now();
        emotion.observation = "Segunda emotion ALEGRE";
        emotions.add(emotion);

        emotion = new TeamEmotion();
        emotion.emotion = Emotion.TRISTE;
        emotion.registered = LocalDateTime.now();
        emotion.observation = "Triste, he perdido a mi perro";
        emotions.add(emotion);

        emotion = new TeamEmotion();
        emotion.emotion = Emotion.ENTUSIASMADO;
        emotion.registered = LocalDateTime.now();
        emotion.observation = "Entusiasmado con el nuevo proyecto";
        emotions.add(emotion);

        team.teamEmotions = emotions;

        persist(team);

    }
}
