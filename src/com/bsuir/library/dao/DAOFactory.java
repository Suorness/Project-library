package com.bsuir.library.dao;

import com.bsuir.library.dao.implementation.FileBookDAO;
import com.bsuir.library.dao.implementation.FileUserDAO;

public class DAOFactory {

    private static final DAOFactory factory = new DAOFactory();

    private final BookDAO bookDAO = new FileBookDAO();
    private final UserDAO userDAO = new FileUserDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return factory;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

}