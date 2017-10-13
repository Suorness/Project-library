package com.bsuir.library.service.exception;

/**
 * Thrown when in Service error occurs.
 */
public class ServiceException extends Exception {

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
    public ServiceException(Exception e){
        super(e);
    }
}
