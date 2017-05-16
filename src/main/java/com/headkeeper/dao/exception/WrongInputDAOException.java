package com.headkeeper.dao.exception;

public class WrongInputDAOException extends DAOException {
    public WrongInputDAOException() {
        super();
    }

    public WrongInputDAOException(String message) {
        super(message);
    }

    public WrongInputDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputDAOException(Throwable cause) {
        super(cause);
    }
}
