package com.bsuir.library.service.exception;

public class ServiceException extends Exception {

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
    public ServiceException(Exception e){
        super(e);
    }
}
