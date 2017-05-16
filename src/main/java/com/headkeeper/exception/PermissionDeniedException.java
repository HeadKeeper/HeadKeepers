package com.headkeeper.exception;

public class PermissionDeniedException extends RuntimeException {
    public PermissionDeniedException() {}

    public PermissionDeniedException(String message) {
        super(message);
    }

    public PermissionDeniedException(Throwable cause) {
        super(cause);
    }

    public PermissionDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionDeniedException(String message, Exception exception) {
        super(message, exception);

    }
}

