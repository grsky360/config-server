package ilio.config.router;

import ilio.config.model.web.R;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.function.Supplier;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class AbstractRouter {
    protected R doAction(Runnable runnable) {
        runnable.run();
        return R.empty();
    }

    protected R doAction(Supplier<Object> supplier) {
        return R.of(supplier.get());
    }

    protected R empty() {
        return R.empty();
    }

    protected R doReturn(Object data) {
        return R.of(data);
    }
}
