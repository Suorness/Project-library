package com.bsuir.library.domain.User.RoleCommands;


import static com.bsuir.library.view.Constant.*;
/**
 * Enumeration providing access to the list of user commands
 */
public enum UserCommands{
    /**
     * The command to get a list of books
     */
    SHOWLIST(0,ShowList.getName()),
    /**
     * Search command in the book catalog
     */
    SEARCH(1, Search.getName()),
    /**
     * Log Out.
     */
    LOGOUT(2,LogOut.getName()),

    /**
     * Exit
     */
    EXIT(3, Exit.getName());

    private int index;
    private String name;
    UserCommands(int value,String name){
        index=value;
        this.name=name;
    }
    /**
     * matches the sequence number and text representation of the command
     * @param value the sequence number in the enum
     * @return Text representation of the command
     */
    public static UserCommands getIndex(int value){
        for (UserCommands command: UserCommands.values()){
            if (value==command.getIndex()){
                return command;
            }
        }
        return null;

    }
    /**
     * Compares the command number and the enumeration element
     * @return   enumeration element with text representation of the command
     */
    public String getCommandName(){
        return name;
    }
    /**
     *  Gets the command index
     * @return the sequence number in the enum
     */
    public int getIndex() {
        return index;
    }

}