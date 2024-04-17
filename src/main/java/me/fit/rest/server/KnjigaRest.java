package me.fit.rest.server;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse.Status;
import me.fit.exception.KnjigaException;
import me.fit.model.Knjiga;
import me.fit.model.rest.client.IPLog;
import me.fit.rest.client.IPClient;
import me.fit.service.KnjigaService;

@Path("/api/knjiga")
public class KnjigaRest {

    @Inject
    private KnjigaService knjigaService;

    @RestClient
    private IPClient ipclient;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createKnjiga")
    @Operation(summary = "Web servis koji kreira novu knjigu.")
    public Response createKnjiga(Knjiga knjiga) {
        Knjiga createdKnjiga = null;
        try {
        	IPLog iplog = ipclient.getIp();
            createdKnjiga = knjigaService.createKnjiga(knjiga, iplog);
        } catch (KnjigaException e) {
            return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok().entity(createdKnjiga).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllKnjige")
    public Response getAllKnjige() {
        List<Knjiga> knjige = knjigaService.getAllKnjige();
        return Response.ok().entity(knjige).build();
    }

}
