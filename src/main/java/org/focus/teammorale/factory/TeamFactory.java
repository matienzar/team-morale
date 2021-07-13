package org.focus.teammorale.factory;

import org.focus.teammorale.data.SimpleTeam;
import org.focus.teammorale.data.Team;

import java.util.Date;

public class TeamFactory {
    private static TeamFactory teamFactoryFactoryInstance;

    private TeamFactory() {
    }

    public static TeamFactory getInstance() {
        if (teamFactoryFactoryInstance == null) {
            teamFactoryFactoryInstance = new TeamFactory();
        }
        return teamFactoryFactoryInstance;
    }

    public Team getTeam(Teams teamFactoryEnum, String teamName, Date from, Date to, String purpose, int membership) {
        switch (teamFactoryEnum) {
            case SIMPLE_TEAM: {
                return SimpleTeam.SimpleTeamBuilder.aSimpleTeam(teamName,from,to, purpose,membership).build();
            }
            default: {
                return null;
            }
        }
    }

}