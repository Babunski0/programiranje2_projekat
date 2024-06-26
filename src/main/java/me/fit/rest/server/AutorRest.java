package me.fit.rest.server;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.rest.client.Autor;
import me.fit.rest.client.AutorClient;

@Path("/api/autor/")
public class AutorRest {
	
	@Inject
	@RestClient
	private AutorClient autorClient;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAutori")
	public Response getAllAutori() {
		List<Autor> autori =  autorClient.getAll();
		return Response.ok().entity(autori).build();
	}
	
	

}
