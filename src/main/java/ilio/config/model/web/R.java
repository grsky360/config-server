package ilio.config.model.web;

public record R(int code, String message, Object data) {

    public static R of(ErrorCode code) {
        return new R(code.code(), code.name(), null);
    }

    public static R of(ErrorCode code, String message) {
        return new R(code.code(), message, null);
    }

    public static R of(Object data) {
        return new R(ErrorCode.OK.code(), ErrorCode.OK.name(), data);
    }

    public static R empty() {
        return new R(ErrorCode.OK.code(), ErrorCode.OK.name(), null);
    }
}
