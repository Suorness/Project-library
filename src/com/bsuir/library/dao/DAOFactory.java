package com.bsuir.library.dao;

import com.bsuir.library.dao.implementation.FileBookDAO;
import com.bsuir.library.dao.implementation.FileUserDAO;

/**
 * This is an class that provides access to the storage mechanism UserDao and BookDAO
 */
public class DAOFactory {

    private static final DAOFactory factory = new DAOFactory();

    private final BookDAO bookDAO = new FileBookDAO();
    private final UserDAO userDAO = new FileUserDAO();

    private DAOFactory() {
    }

    /**
     * The method that returns an instance DAOFactory
     * @return  instance DAOFactory
     */
    public static DAOFactory getInstance() {
        return factory;
    }

    /**
     *  The method that returns an instance BookDAO
     * @return instance BookDAO
     */
    public BookDAO getBookDAO() {
        return bookDAO;
    }

    /**
     * The method that returns an instance UserDAO
     * @return instance UserDAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

}