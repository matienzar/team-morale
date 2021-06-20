package org.mutua.teammorale.data;

import java.util.Date;
import java.util.List;

public interface Team {
    String getTeamName();

    void setTeamName(String teamName);

    Date getFrom();

    void setFrom(Date from);

    Date getTo();

    void setTo(Date to);

    List<TeamEmotion> getTeamEmotions();

    void setTeamEmotions(List<TeamEmotion> teamEmotions);

    String getPurpose();

    void setPurpose(String purpose);

    int getMembership();

    void setMembership(int membership);

    void addEmotion(TeamEmotion emotion);
}
