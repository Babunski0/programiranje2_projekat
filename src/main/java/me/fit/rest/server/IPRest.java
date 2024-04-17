package me.fit.rest.server;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.rest.client.IPLog;
import me.fit.rest.client.IPClient;

@Path("/api/iplog/")
public class IPRest {
	
	@Inject
	@RestClient
	private IPClient ipclient;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getIPLog")
	public Response getAllAutori() {
		IPLog iplog =  ipclient.getIp();
		return Response.ok().entity(iplog).build();
	}

}
