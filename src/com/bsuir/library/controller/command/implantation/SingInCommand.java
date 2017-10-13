package com.bsuir.library.controller.command.implantation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.UserService;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.implementation.ConsoleView;

import java.util.Scanner;

import static com.bsuir.library.view.Constant.*;

public class SingInCommand implements Command {
    @Override
    public void execute(String request) {
        view.outputLine(EnterLogin.getName());
        String login = in.nextLine().trim();
        view.outputLine(EnterPassword.getName());
        String passWord = in.nextLine().trim();
        boolean result = false;
        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            UserService userService = factory.getUserService();
            result = userService.logIn(login, passWord);

        }catch (ServiceException exc){
            view.showErrorInfo(exc.getMessage());
            throw new RuntimeException(exc);
        }
        if (result){
            view.outputLine(SuccessAut.getName());
        }
        else
        {
            view.outputLine(FailAut.getName());
        }
    }
    public SingInCommand(){
        view = new ConsoleView();
        in = new Scanner(System.in);
    }

    private ConsoleView view;
    private Scanner in;
}
