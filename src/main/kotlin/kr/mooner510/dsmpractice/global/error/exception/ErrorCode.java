package kr.mooner510.dsmpractice.global.error.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // Global
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),

    // User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    USER_EXISTS(HttpStatus.CONFLICT, "User already exists"),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "Invalid credentials"),
    PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "Password mismatch"),

    // Token / JWT
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired JWT token"),
    INVALID_JWT(HttpStatus.UNAUTHORIZED, "Invalid JWT token"),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid refresh token"),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "Refresh token not found");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
