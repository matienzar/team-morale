package org.focus.teammorale.api;

import org.focus.teammorale.data.Team;
import org.focus.teammorale.dto.TeamMorale;
import org.focus.teammorale.repository.TeamRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/team/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamRepository teamRepository;

    @GET
    @Path("/{id}")
    public TeamMorale get(@PathParam("id") String teamId,
                          @QueryParam("start") LocalDate start,
                          @QueryParam("end") LocalDate end) {
        return teamRepository.findTeam(teamId, start, end);
    }

    // Must be a DELETE, introduce POSTMAN
    @DELETE
    @Path("/reset")
    public Response reset() {
        teamRepository.reset();
        return Response.ok("Limpieza realizada").build();
    }

    @POST
    @Path("/init")
    public Response init() {
        teamRepository.init();
        return Response.ok("Colecciones inicializadas").build();
    }

    @GET
    @Path("/init-db")
    public Response initDatabase() {
        teamRepository.initDatabase();
        return Response.ok("Base de datos inicializada").build();
    }
}
