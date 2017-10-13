package com.bsuir.library.dao.exception;

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
