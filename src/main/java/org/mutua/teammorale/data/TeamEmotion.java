package org.mutua.teammorale.data;

import java.io.Serializable;
import java.util.List;


public class TeamEmotion implements Serializable {

    private List<String> observations;
    private int times;
    private Emotion emotion;

    private TeamEmotion(int times, Emotion emotion) {
        this.times = times;
        this.emotion = emotion;
    }

    public List<String> getObservations() {
        return observations;
    }

    public void setObservations(List<String> observations) {
        this.observations = observations;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public static final class TeamEmotionBuilder {
        private List<String> observations;
        private int times;
        private Emotion emotion;

        private TeamEmotionBuilder(int times, Emotion emotion) {
            this.times = times;
            this.emotion = emotion;
        }

        public static TeamEmotionBuilder aTeamEmotion(int times, Emotion emotion) {
            return new TeamEmotionBuilder(times, emotion);
        }

        public TeamEmotionBuilder withObservations(List<String> observations) {
            this.observations = observations;
            return this;
        }

        public TeamEmotion build() {
            TeamEmotion teamEmotion = new TeamEmotion(times, emotion);
            teamEmotion.setObservations(observations);
            return teamEmotion;
        }
    }
}
