package com.headkeeper.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message, Exception exception) {
        super(message, exception);

    }
}
