package com.bsuir.library.dao;

import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.User.User;

import java.util.ArrayList;

/**
 * The UserDAO interface should be implemented by any class whose instances are intended
 * to be provides an interface to any type of database or storage engine.
 * Designed to obtain a catalog of users.
 */
public interface UserDAO {
    /**
     * Gets a list of Users from DAO
     * @return List of Users
     * @throws DAOException Thrown when in Data Access Object(DAO) error occurs.
     */
    ArrayList<User> getUserList() throws DAOException;

    /**
     * Sets the list of users in DAO
     * @param list List of users
     * @throws DAOException Thrown when in Data Access Object(DAO) error occurs.
     */
    void setUserList(ArrayList<User> list) throws DAOException;

}
