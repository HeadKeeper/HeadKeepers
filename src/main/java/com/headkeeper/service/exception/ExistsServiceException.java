package com.headkeeper.service.exception;

public class ExistsServiceException extends ServiceException {
    public ExistsServiceException() {
        super();
    }

    public ExistsServiceException(String message) {
        super(message);
    }

    public ExistsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistsServiceException(Throwable cause) {
        super(cause);
    }
}
