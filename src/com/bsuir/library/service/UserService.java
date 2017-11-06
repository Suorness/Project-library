package com.bsuir.library.service;

import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.domain.User.User;

import java.util.List;

/**
 * The UserService should be implemented by any class that provides access to work with user
 */
public interface UserService {
    /**
     * User Registration Function
     * @param login user login
     * @param password user password
     * @return true - registered, false - not registered
     * @throws ServiceException Thrown when in Service error occurs.
     */
    boolean register(String login, String password) throws ServiceException;

    /**
     * Login function
     * @param login user login
     * @param password user password
     * @return true - logged in, false - not logged in
     * @throws ServiceException Thrown when in Service error occurs.
     */
    boolean logIn(String login, String password) throws ServiceException;

    /**
     *  Sign Out
     * @throws ServiceException Thrown when in Service error occurs.
     */
    void logOut () throws ServiceException;

    /**
     *  Getting user role
     * @return user role
     */
    User.Role getCurrentRole();
    List<User> getUserList()throws ServiceException;
}
