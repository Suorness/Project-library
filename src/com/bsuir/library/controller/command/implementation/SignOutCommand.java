package com.bsuir.library.controller.command.implementation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.UserService;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;

/**
 * The class that implements the command interface allows you sign out.
 */
public class SignOutCommand implements Command {
    /**
     * @see Command interface
     */
    @Override
    public void execute() {
        try {
            userService.logOut();
        }catch (ServiceException e){
            view.showErrorInfo(e.getMessage());
        }
    }
    public SignOutCommand(){
        ViewFactory factory = ViewFactory.getInstance();
        view  = factory.getView();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        userService = serviceFactory.getUserService();
    }


    private UserService userService;
    private View view;


}
