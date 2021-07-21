package org.focus.teammorale.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeamMorale {
    private long maxOnPeriod = 0;
    private LocalDate from;
    private LocalDate to;
    private List<MoraleEmotion> emotions = new ArrayList<>();

    public long getMaxOnPeriod() {
        return maxOnPeriod;
    }

    public void setMaxOnPeriod(long maxOnPeriod) {
        this.maxOnPeriod = maxOnPeriod;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public List<MoraleEmotion> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<MoraleEmotion> emotions) {
        this.emotions = emotions;
    }
}
