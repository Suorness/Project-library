package com.bsuir.library.dao;

import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.User;

import java.util.ArrayList;

public interface UserDAO {

    boolean register(User user) throws DAOException;
    boolean logination(String login, String password) throws DAOException;

    ArrayList<User> getUserList() throws DAOException;
    void setUserList(ArrayList<User> list) throws DAOException;
    //TODO:: appEndUserList

}
