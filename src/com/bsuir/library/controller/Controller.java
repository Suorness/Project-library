package com.bsuir.library.controller;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.domain.User;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.UserService;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;
import com.bsuir.library.view.implementation.ConsoleView;

import java.util.Scanner;

import static com.bsuir.library.view.Constant.ErrorInput;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

    private boolean working;
    private Scanner in = new Scanner(System.in);

    private View view;
    private UserService userService;

    public Controller() {
        ServiceFactory factory = ServiceFactory.getInstance();
        userService = factory.getUserService();
        ViewFactory viewFactory =  ViewFactory.getInstance();
        view = viewFactory.getView();
    }

    public String doAction(String request) {

        String commandName;

        commandName = request.split(" ")[0];

        Command command = provider.getCommand(commandName);

        String response = "";
        if(command!=null) {
            command.execute(request);
        }
        else
            //TODO::
            view.outputLine("ERROR COMMAND!!");
        return response;
    }
    public void Start(){
        working = true;
        int index;
        String request;
        while (working){
            view.showListCommand(userService.getCurrentRole());
            request = in.nextLine();
            try{
                index = Integer.parseInt(request);
                chooseCommand(index,userService.getCurrentRole());
            }
            catch (NumberFormatException e){
                view.showErrorInfo(e.getMessage());
            }

        }

    }
    private void chooseCommand(int index,User.Role role) {
        switch (role) {
            case ADMIN:
                ConsoleView.AdminCommands adminCommands = ConsoleView.AdminCommands.getIndex(index);
                if (adminCommands!=null) {
                    switch (adminCommands) {
                        case SHOWLIST:
                            doAction("show_list");
                            break;
                        case SEARCH:
                            doAction("search");
                            break;
                        case DELBOOK:
                            doAction("delBook");
                            break;
                        case LOGOUT:
                            doAction("logOut");
                            break;
                        case EXIT:
                            working = false;
                            break;
                        case ADDBOOK:
                            doAction("add_book");
                            break;
                        default:
                            view.outputLine(ErrorInput.getName());
                            break;
                    }
                }
                else{
                    view.outputLine(ErrorInput.getName());
                }

                break;
            case USER:
                ConsoleView.UserCommands userCommands = ConsoleView.UserCommands.getIndex(index);
                if (userCommands!=null){
                switch (userCommands) {
                    case SHOWLIST:
                        doAction("show_list");
                        break;
                    case SEARCH:
                        doAction("search");
                        break;
                    case LOGOUT:
                        doAction("logOut");
                        break;
                    case EXIT:
                        working = false;
                        break;
                    default:
                        view.outputLine(ErrorInput.getName());
                        break;
                }
            }
            else{
                    view.outputLine(ErrorInput.getName());
                }
                break;
            case GUEST:
                ConsoleView.GuestCommands guestCommands = ConsoleView.GuestCommands.getIndex(index);
                if (guestCommands!=null) {
                    switch (guestCommands) {
                        case SIGNUP:
                            doAction("signUp");
                            break;
                        case SIGNIN:
                            doAction("signIn");
                            break;
                        case EXIT:
                            working = false;
                            break;

                    }
                }
                else{
                    view.outputLine(ErrorInput.getName());
                }
                break;
        }
    }


}