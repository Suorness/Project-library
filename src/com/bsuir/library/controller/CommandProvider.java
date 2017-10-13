package com.bsuir.library.controller;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.controller.command.implementation.*;

import java.util.HashMap;
import java.util.Map;

import static com.bsuir.library.controller.command.DesignationCommands.*;

/**
 * Provides access to the list of commands by text representation
 */
class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put(SIGNUPCOMMAND.getName(),new SignUpCommand());
        commands.put(LOGOUTCOMMAND.getName(), new SignOutCommand());
        commands.put(SIGNINCOMMAND.getName(),new SignInCommand());

        commands.put(ADDBOOKCOMMAND.getName(), new AddBookCommand());
        commands.put(DELBOOKCMMAND.getName(), new DeleteBookCommand());
        commands.put(SEACHBOOKCOOMMAND.getName(), new FindBookCommand());
        commands.put(SHOWBOOKCOMMAND.getName(), new BrowseBookCatalogCommand());



    }

    /**
     *
     * @param commandName Text representation of the command
     * @return Command instance
     */
    Command getCommand(String commandName) {
        Command command;
        command = commands.get(commandName);
        return command;

    }

}