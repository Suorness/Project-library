package com.bsuir.library.controller;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.domain.User.RoleCommands.GuestCommands;
import com.bsuir.library.domain.User.RoleCommands.UserCommands;
import com.bsuir.library.domain.User.User;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.UserService;
import com.bsuir.library.view.Reader;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;
import com.bsuir.library.domain.User.RoleCommands.AdminCommands;

import static com.bsuir.library.controller.command.DesignationCommands.*;
import static com.bsuir.library.view.Constant.ErrorInput;

/**
 * The main task of the controller is to determine the required action,
 * correctly accept the data, correctly return the result.
 */
public class Controller {

    private final CommandProvider provider = new CommandProvider();

    private boolean working;
    private Reader reader;
    private View view;
    private UserService userService;

    public Controller() {
        ServiceFactory factory = ServiceFactory.getInstance();
        userService = factory.getUserService();
        ViewFactory viewFactory =  ViewFactory.getInstance();
        view = viewFactory.getView();
        reader = viewFactory.getReader();
    }

    /**
     * Performs action upon request
     * @param request Action request
     */
    void  doAction(String request) {

        String commandName;
        commandName = request.split(" ")[0];
        Command command = provider.getCommand(commandName);
        if(command!=null) {
            command.execute();
        }
    }

    /**
     * Starting the controller
     */
    public void Start() {
        working = true;
        int index;
        while (working) {
            view.showListCommand(userService.getCurrentRole());
            index = reader.dataInputInt();
            chooseCommand(index, userService.getCurrentRole());
        }
    }

    /**
     * Defines an action to call
     * @param index Number of the selected action
     * @param role the role of the current user
     */
    private void chooseCommand(int index,User.Role role) {
        switch (role) {
            case ADMIN:
                AdminCommands adminCommands = AdminCommands.getIndex(index);
                if (adminCommands!=null) {
                    switch (adminCommands) {
                        case SHOWLIST:
                            doAction(SHOWBOOKCOMMAND.getName());
                            break;
                        case SEARCH:
                            doAction(SEACHBOOKCOOMMAND.getName());
                            break;
                        case DELBOOK:
                            doAction(DELBOOKCMMAND.getName());
                            break;
                        case LOGOUT:
                            doAction(LOGOUTCOMMAND.getName());
                            break;
                        case EXIT:
                            working = false;
                            break;
                        case ADDBOOK:
                            doAction(ADDBOOKCOMMAND.getName());
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
                UserCommands userCommands = UserCommands.getIndex(index);
                if (userCommands!=null){
                switch (userCommands) {
                    case SHOWLIST:
                        doAction(SHOWBOOKCOMMAND.getName());
                        break;
                    case SEARCH:
                        doAction(SEACHBOOKCOOMMAND.getName());
                        break;
                    case LOGOUT:
                        doAction(LOGOUTCOMMAND.getName());
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
                GuestCommands guestCommands = GuestCommands.getIndex(index);
                if (guestCommands!=null) {
                    switch (guestCommands) {
                        case SIGNUP:
                            doAction(SIGNUPCOMMAND.getName());
                            break;
                        case SIGNIN:
                            doAction(SIGNINCOMMAND.getName());
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