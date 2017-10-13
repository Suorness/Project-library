package com.bsuir.library.controller.command.implantation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.UserService;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.implementation.ConsoleView;

import java.util.Scanner;

public class SignOut implements Command {
    @Override
    public void execute(String request) {
        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            UserService userService = factory.getUserService();
            userService.logOut();
        }catch (ServiceException e){
            view.showErrorInfo(e.getMessage());
        }
    }
    public SignOut(){
        view = new ConsoleView();
        in = new Scanner(System.in);
    }
    private ConsoleView view;
    private Scanner in;

}
