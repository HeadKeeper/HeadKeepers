package com.headkeeper.dao.exception;

public class ExistsDAOException extends DAOException {
    public ExistsDAOException() {
        super();
    }

    public ExistsDAOException(String message) {
        super(message);
    }

    public ExistsDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistsDAOException(Throwable cause) {
        super(cause);
    }
}
