package com.bsuir.library.controller.command.implementation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.UserService;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.Reader;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;


import static com.bsuir.library.view.Constant.*;

/**
 * The class that implements the command interface allows you sign in.
 */
public class SignInCommand implements Command {
    /**
     * @see Command interface
     */
    @Override
    public void execute() {
        String login;
        String passWord;
        view.outputLine(EnterLogin.getName());
        login = reader.dataInputString();
        view.outputLine(EnterPassword.getName());
        passWord = reader.dataInputString();
        boolean result = false;
        try {
            result = userService.logIn(login, passWord);
        } catch (ServiceException exc) {
            view.showErrorInfo(exc.getMessage());
        }
        if (result) {
            view.outputLine(SuccessAut.getName());
        } else {
            view.outputLine(FailAut.getName());
        }
    }

    public SignInCommand() {
        ViewFactory factory = ViewFactory.getInstance();
        view = factory.getView();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        userService = serviceFactory.getUserService();
        reader = factory.getReader();
    }

    private UserService userService;
    private View view;
    private Reader reader;

}
