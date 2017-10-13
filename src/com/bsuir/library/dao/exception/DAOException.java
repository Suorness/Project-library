package com.bsuir.library.dao.exception;

/**
 * Thrown when in Data Access Object(DAO) error occurs.
 */
public class DAOException extends Exception {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
    public DAOException(Exception e){
        super(e);
    }
}
