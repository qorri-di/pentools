package id.qodev.pentool.controller;

import id.qodev.pentool.common.GenericResponseDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.jboss.logging.Logger;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/pentool/v1-api/wordlist")
public class wordlistController {
    @Inject
    Logger log;

    @POST
    @Path("/save")
    public GenericResponseDTO<?> save(){
        log.infof("--------------- RESPONSE [[ %s ]] ---------------", "cuuk");
        return new GenericResponseDTO<>().successResponse();
    }

    @POST
    @Path("/delete")
    public GenericResponseDTO<?> delete(){
        log.infof("--------------- RESPONSE [[ %s ]] ---------------", "cuuk");
        return new GenericResponseDTO<>().successResponse();
    }

    @POST
    @Path("/view")
    public GenericResponseDTO<?> view(){
        log.infof("--------------- RESPONSE [[ %s ]] ---------------", "cuuk");
        return new GenericResponseDTO<>().successResponse();
    }
}
