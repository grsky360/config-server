package ilio.config.router;

import ilio.config.model.web.R;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class PingRouter extends AbstractRouter {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ping")
    public R hello() {
        return doReturn("pong");
    }
}