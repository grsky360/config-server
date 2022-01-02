package ilio.config.model.web;

import lombok.Getter;

public class CodeException extends RuntimeException {

    @Getter
    private final ErrorCode code;
    @Getter
    private final String message;

    public CodeException(ErrorCode code) {
        this(code, null, null);
    }

    public CodeException(ErrorCode code, String message) {
        this(code, message, null);
    }

    public CodeException(ErrorCode code, Throwable throwable) {
        this(code, null, throwable);
    }

    public CodeException(ErrorCode code, String message, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.message = message;
    }

}
