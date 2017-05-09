package com.headkeeper.exception;

public class ValidationException extends RuntimeException {
    public ValidationException() {}

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message, Exception exception) {
        super(message, exception);

    }
}
