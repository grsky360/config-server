package ilio.config.router;

import ilio.config.config.FileConfiguration;
import ilio.config.model.web.R;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/admin")
public class AdminRouter extends AbstractRouter{

    @Inject
    FileConfiguration fileConfiguration;

    @GET
    @Path("/configuration/file-base")
    public R getFileBase() {
        return doReturn(fileConfiguration.getFileBase());
    }
}
