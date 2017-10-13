package com.bsuir.library.service;

import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.domain.User;

public interface UserService {
 /// TODO:посмотреть что тут за методы и написать USER
    boolean register(String login, String password) throws ServiceException;
    boolean logIn(String login, String password) throws ServiceException;
    void logOut () throws ServiceException;
    User.Role getCurrentRole();
}
