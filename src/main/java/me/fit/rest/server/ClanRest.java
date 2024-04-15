package me.fit.rest.server;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.reactive.RestResponse.Status;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.ClanException;
import me.fit.model.Clan;
import me.fit.service.ClanService;

@Path("/api/clan/")
public class ClanRest {
	
	@Inject
	private ClanService clanService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createClan")
	@Operation(summary = "Web servis koji kreira novog clana.",
    description = "Clan mora biti unikatan.")
	public Response createClan(Clan clan){
		Clan c = null;
		try {
			c = clanService.createClan(clan);
		} catch (ClanException e) {
			return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
		}
		return Response.ok().entity(c).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getClan")
	public Response getAllClan() {
		List<Clan> clanovi =  clanService.getAllClan();
		return Response.ok().entity(clanovi).build();
	}
	

}
