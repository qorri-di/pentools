package id.qodev.pentool.controller;

import id.qodev.pentool.common.GenericResponseDTO;
import id.qodev.pentool.dto.createOrUpdateRequest;
import io.vertx.core.json.JsonObject;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/pentool/v1-api/wordlist")
public class typeListController {
    @Inject
    Logger log;

    @POST
    @Path("/type_create")
    public GenericResponseDTO<?> create(createOrUpdateRequest request){
        log.infof("-+[ START CREATE TYPE %s ]+-", new JsonObject().mapFrom(request).encode());
        return new GenericResponseDTO<>().successResponse();
    }

    @POST
    @Path("/type_update")
    public GenericResponseDTO<?> edit(createOrUpdateRequest request){
        log.infof("-+[ START UPDATE TYPE %s ]+-", new JsonObject().mapFrom(request).encode());
        return new GenericResponseDTO<>().successResponse();
    }

    @POST
    @Path("/type_delete")
    public GenericResponseDTO<?> delete(createOrUpdateRequest request){
        log.infof("-+[ START DELETE TYPE %s ]+-", new JsonObject().mapFrom(request).encode());
        return new GenericResponseDTO<>().successResponse();
    }

    @POST
    @Path("/type_read")
    public GenericResponseDTO<?> read(createOrUpdateRequest request){
        log.infof("-+[ START READ TYPE %s ]+-", new JsonObject().mapFrom(request).encode());
        return new GenericResponseDTO<>().successResponse();
    }
}
