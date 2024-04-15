package me.fit.rest.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.fit.model.rest.client.Autor;

@Path("/api/v3")
@RegisterRestClient
public interface AutorClient {
	@GET
	@Path("/AvailableAutor")
    List<Autor> getAll();

}
