package ilio.config.router;

import ilio.config.model.web.R;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/ping")
public class PingRouter extends AbstractRouter {

    @GET
    public R hello() {
        return doReturn("pong");
    }
}