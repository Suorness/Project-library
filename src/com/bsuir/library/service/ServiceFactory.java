package com.bsuir.library.service;

import com.bsuir.library.service.implementation.BookServiceImpl;
import com.bsuir.library.service.implementation.MailServiceImpl;
import com.bsuir.library.service.implementation.UserServiceImpl;
/**
 * This is an class that provides access to the service mechanism BookService and UserService
 */
public class ServiceFactory {

    private static final ServiceFactory factory = new ServiceFactory();

    private final BookService bookService = new BookServiceImpl();
    private final UserService userService = UserServiceImpl.getInstance();//new UserServiceImpl();
    private ServiceFactory() {
    }
    /**
     * The method that returns an instance ServiceFactory
     * @return  instance ServiceFactory
     */
    public static ServiceFactory getInstance() {
        return factory;
    }
    /**
     *  The method that returns an instance BookService
     * @return instance BookService
     */
    public BookService getBookService() {
        return bookService;
    }
    /**
     *  The method that returns an instance UserService
     * @return instance UserService
     */
    public UserService getUserService() {
        return userService;
    }
    public MailService getMailService(){
        return MailServiceImpl.getInstance();
    }
}
