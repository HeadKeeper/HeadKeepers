package com.headkeeper.dao.exception;

public class NotFoundDAOException extends DAOException {
    public NotFoundDAOException() {
        super();
    }

    public NotFoundDAOException(String message) {
        super(message);
    }

    public NotFoundDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundDAOException(Throwable cause) {
        super(cause);
    }
}
