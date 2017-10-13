package com.bsuir.library.controller.command;

/**
 * Enumeration storing the text version of the command name.
 */
public enum DesignationCommands {

    /**
     * Adding a book
     */
    ADDBOOKCOMMAND("add_book"),
    /**
     * Delete a book.
     */
    DELBOOKCMMAND("delBook"),

    /**
     * Search book.
     */
    SEACHBOOKCOOMMAND("search"),

    /**
     * Show list book.
     */
    SHOWBOOKCOMMAND("show_list"),

    /**
     * Sign Up.
     */
    SIGNUPCOMMAND("signUp"),

    /**
     * LogOut.
     */
    LOGOUTCOMMAND("logOut"),
    /**
     * Sign In
     */
    SIGNINCOMMAND("signIn");

    private String name;

    DesignationCommands(String name){
        this.name = name;
    }

    /**
     * @return Text representation of the command.
     */
    public String getName(){
        return name;
    }
}
