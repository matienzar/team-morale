package org.mutua.teammorale.api;

import org.mutua.teammorale.data.Emotion;
import org.mutua.teammorale.data.Team;
import org.mutua.teammorale.data.TeamEmotion;
import org.mutua.teammorale.factory.TeamFactory;
import org.mutua.teammorale.factory.Teams;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Path("/team/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

    @GET
    public Team getTeamMorale() {
        Calendar from = Calendar.getInstance();
        from.set(Calendar.DAY_OF_MONTH,1);

        Calendar to = Calendar.getInstance();
        to.set(Calendar.DAY_OF_MONTH, to.getActualMaximum(Calendar.DAY_OF_MONTH));

        Team team = TeamFactory.getInstance()
                .getTeam(Teams.SIMPLE_TEAM, "Kyrian",from.getTime(),to.getTime(),"Hacemos realidad tus ideas",10);

        TeamEmotion.TeamEmotionBuilder teamEmotionBuilder1 = TeamEmotion.TeamEmotionBuilder.aTeamEmotion(3, Emotion.ABURRIDO);
        List<String> observations1 = new ArrayList<>();
        observations1.add("Semana muy rutinaria. No hemos introducido ninguna mejora");
        teamEmotionBuilder1.withObservations(observations1);
        team.addEmotion(teamEmotionBuilder1.build());

        TeamEmotion.TeamEmotionBuilder teamEmotionBuilder2 = TeamEmotion.TeamEmotionBuilder.aTeamEmotion(5, Emotion.CALMADO);
        List<String> observations2 = new ArrayList<>();
        observations2.add("Hacía falta una semana así para poder parar, pensar y retomar el rumbo");
        teamEmotionBuilder2.withObservations(observations2);
        team.addEmotion(teamEmotionBuilder2.build());


        return team;
    }
}
