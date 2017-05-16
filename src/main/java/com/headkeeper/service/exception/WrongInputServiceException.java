package com.headkeeper.service.exception;

public class WrongInputServiceException extends ServiceException {
    public WrongInputServiceException() {
        super();
    }

    public WrongInputServiceException(String message) {
        super(message);
    }

    public WrongInputServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputServiceException(String message, Exception exception) {
        super(message, exception);
    }

    public WrongInputServiceException(Throwable cause) {
        super(cause);
    }
}
