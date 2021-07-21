package org.focus.teammorale.dto;

import org.focus.teammorale.data.Emotion;

public class MoraleEmotion {
    private Emotion emotion;
    private Long totalOnPeriod;

    public MoraleEmotion(Emotion emotion, Long totalOnPeriod) {
        this.emotion = emotion;
        this.totalOnPeriod = totalOnPeriod;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Long getTotalOnPeriod() {
        return totalOnPeriod;
    }

    public void setTotalOnPeriod(Long totalOnPeriod) {
        this.totalOnPeriod = totalOnPeriod;
    }
}
