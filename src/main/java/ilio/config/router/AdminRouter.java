package ilio.config.router;

import ilio.config.config.FileConfiguration;
import ilio.config.model.web.R;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/admin")
public class AdminRouter extends AbstractRouter {

    @Inject
    FileConfiguration fileConfiguration;


    @Inject
    MasterKeyRepository masterKeyRepository;

    @GET
    @Path("/configuration/file-base")
    public R getFileBase() {
        return doReturn(fileConfiguration.getFileBase());
    }

    @GET
    @Path("/master-keys")
    public R getMasterKeys() {
        return doAction(() -> masterKeyRepository.findAll());
    }

    @POST
    @Path("/master-keys")
    public R postMasterKeys() {
        MasterKey masterKey = new MasterKey();
        masterKey.setMasterKey("as");
        masterKey.setActive(true);
        masterKeyRepository.save(masterKey);
        return empty();
    }
}
