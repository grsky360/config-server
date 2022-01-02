package ilio.config.router;

import ilio.config.model.web.R;

import java.util.function.Supplier;

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
