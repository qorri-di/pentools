package id.qodev.pentool.controller;

import id.qodev.pentool.dto.GeneralResponse;
import id.qodev.pentool.dto.hello.HelloRequestDto;
import id.qodev.pentool.service.HelloService;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/minilab/sample")
public class Minilab1Controller {

    @Inject
    HelloService helloService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello EKSAD's Lovers ";
    }

    @POST
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloPost(HelloRequestDto request) {
        GeneralResponse response=helloService.helloService(request);
        JsonObject jsonResponse=JsonObject.mapFrom(response);
        return Response.ok(jsonResponse).build();
    }
}