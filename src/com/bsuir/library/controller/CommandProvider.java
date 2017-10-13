package com.bsuir.library.controller;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.controller.command.implantation.*;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put("signUp",new SignUpCommand());
        commands.put("logOut", new SignOut());
        commands.put("signIn",new SingInCommand());

        commands.put("add_book", new AddBookCommand());
        commands.put("delBook", new DeleteBookCommand());
        commands.put("search", new FindBookCommand());
        commands.put("show_list", new BrowseBookCatalogCommand());



    }

    Command getCommand(String commandName) {
        Command command;
        command = commands.get(commandName);
        return command;

    }

}