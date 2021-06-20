package org.mutua.teammorale.data;

import java.io.Serializable;
import java.util.*;

public class SimpleTeam implements Serializable, Team {

    private String teamName;
    private Date from;
    private Date to;
    private List<TeamEmotion> teamEmotions;
    private String purpose;
    private int membership = 1;

    private SimpleTeam(String teamName, Date start, Date end, String purpose, int membership) {
        this.teamName = teamName;
        this.from = start;
        this.to = end;
        this.purpose = purpose;
        this.membership = membership;
        this.teamEmotions = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public Date getFrom() {
        return from;
    }

    @Override
    public void setFrom(Date from) {
        this.from = from;
    }

    @Override
    public Date getTo() {
        return to;
    }

    @Override
    public void setTo(Date to) {
        this.to = to;
    }


    public List<TeamEmotion> getTeamEmotions() {
        return teamEmotions;
    }

    public void setTeamEmotions(List<TeamEmotion> teamEmotions) {
        this.teamEmotions = teamEmotions;
    }

    @Override
    public String getPurpose() {
        return purpose;
    }

    @Override
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public int getMembership() {
        return this.membership;
    }

    @Override
    public void setMembership(int membership) {
        this.membership = membership;
    }

    @Override
    public void addEmotion(TeamEmotion emotion) {
        this.teamEmotions.add(emotion);
    }

    public static final class SimpleTeamBuilder {
        private final String teamName;
        private final Date from;
        private final Date to;
        private final String purpose;
        private int membership = 1;
        private List<TeamEmotion> teamEmotions;

        private SimpleTeamBuilder(String teamName, Date start, Date end,String purpose, int membership) {
            this.teamName = teamName;
            this.from = start;
            this.to = end;
            this.purpose = purpose;
            this.membership  = membership;
        }

        public static SimpleTeamBuilder aSimpleTeam(String teamName, Date start, Date end,String purpose, int membership) {
            return new SimpleTeamBuilder(teamName, start, end,purpose,membership);
        }

        public SimpleTeamBuilder withTeamEmotions(List<TeamEmotion> teamEmotions) {
            this.teamEmotions = teamEmotions;
            return this;
        }

        public SimpleTeam build() {
            SimpleTeam simpleTeam = new SimpleTeam(teamName, from, to,purpose,membership);
            if (teamEmotions != null) {
                simpleTeam.setTeamEmotions(teamEmotions);
            }
            return simpleTeam;
        }
    }
}
