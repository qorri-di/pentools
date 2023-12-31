package id.qodev.pentool.controller;

import id.qodev.pentool.common.GenericResponseDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import id.qodev.pentool.dto.*;
import id.qodev.pentool.service.wordlistService;
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
        return ws.save(request);
    }

    @POST
    @Path("/edit")
    public GenericResponseDTO<?> edit(createOrUpdateRequest request){
        return ws.save(request);
    }

    @POST
    @Path("/delete")
    public GenericResponseDTO<?> delete(){
        log.infof("--------------- RESPONSE [[ %s ]] ---------------", "cuuk");
        return ws.delete();
    }

    @POST
    @Path("/view")
    public GenericResponseDTO<?> view(){
        log.infof("--------------- RESPONSE [[ %s ]] ---------------", "cuuk");
        return ws.read();
    }
}
