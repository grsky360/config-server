package ilio.config.model.web;

public record ErrorCode(int code, String name) {

    public static final ErrorCode OK = new ErrorCode(0, "OK");
    public static final ErrorCode NOT_AUTHORIZATION = new ErrorCode(40000, "NOT_AUTHORIZATION");
    public static final ErrorCode NO_ACCESS_PERMISSION = new ErrorCode(40001, "NO_ACCESS_PERMISSION");
    public static final ErrorCode USER_NOT_FOUND = new ErrorCode(40010, "USER_NOT_FOUND");
    public static final ErrorCode USER_PASSWORD_INCORRECT = new ErrorCode(40011, "USER_PASSWORD_INCORRECT");
    public static final ErrorCode USER_PASSWORD_NOT_SET = new ErrorCode(400012, "USER_PASSWORD_NOT_SET");
    public static final ErrorCode USER_ACCESS_OUT_OF_HOLDER = new ErrorCode(40013, "USER_ACCESS_OUT_OF_HOLDER");

    public static final ErrorCode NOT_SUPPORT = new ErrorCode(99998, "NOT_SUPPORT");
    public static final ErrorCode INTERNAL_ERROR = new ErrorCode(99999, "INTERNAL_ERROR");

    public int getHttpCode() {
        if (code == 0) {
            return 200;
        }
        if (code > 60000) {
            return 500;
        }
        return code / 100;
    }

    public CodeException exception(String message, Exception e) {
        return new CodeException(this, message, e);
    }

    public CodeException exception(String message) {
        return new CodeException(this, message);
    }
}
