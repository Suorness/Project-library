package com.bsuir.library.service;

import com.bsuir.library.service.implementation.BookServiceImpl;
import com.bsuir.library.service.implementation.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory factory = new ServiceFactory();

    private final BookService bookService = new BookServiceImpl();
    private final UserService userService = UserServiceImpl.getInstance();//new UserServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return factory;
    }

    public BookService getBookService() {
        return bookService;
    }

    public UserService getUserService() {
        return userService;
    }
}
