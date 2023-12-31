package id.qodev.pentool.controller;

import id.qodev.pentool.common.GenericResponseDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import id.qodev.pentool.dto.*;
import id.qodev.pentool.service.wordlistService;
import io.vertx.core.json.JsonObject;
import org.jboss.logging.Logger;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/pentool/v1-api/wordlist")
public class wordlistController {
    @Inject
    wordlistService ws;

    @Inject
    Logger log;

    @POST
    @Path("/create")
    public GenericResponseDTO<?> save(createOrUpdateRequest request){
        log.infof("-+[ START CREATE WORDLIST %s ]+-", new JsonObject().mapFrom(request).encode());
        return ws.save(request);
    }

    @POST
    @Path("/edit")
    public GenericResponseDTO<?> edit(createOrUpdateRequest request){
        log.infof("-+[ START UPDATE WORDLIST %s ]+-", new JsonObject().mapFrom(request).encode());
        return ws.save(request);
    }

    @POST
    @Path("/delete")
    public GenericResponseDTO<?> delete(createOrUpdateRequest request){
        log.infof("-+[ START DELETE WORDLIST %s ]+-", new JsonObject().mapFrom(request).encode());
        return ws.delete(request);
    }

    @POST
    @Path("/view")
    public GenericResponseDTO<?> view(wordlistRequest request){
        log.infof("-+[ START READ WORDLIST %s ]+-", new JsonObject().mapFrom(request).encode());
        return ws.read(request);
    }
}
