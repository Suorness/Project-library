package com.bsuir.library.domain.User.RoleCommands;

import static com.bsuir.library.view.Constant.*;
import static com.bsuir.library.view.Constant.DelBook;
import static com.bsuir.library.view.Constant.Exit;

/**
 * Enumeration providing access to the list of administrative commands
 */
public enum AdminCommands{
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
     * Adding book
     */
    ADDBOOK(3,AddBook.getName()),
    /**
     * Delete a book
     */
    DELBOOK(4,DelBook.getName()),

    /**
     * Exit
     */
    EXIT(5, Exit.getName());

    private int index;
    private String name;
    AdminCommands(int value,String name){
        index=value;
        this.name=name;
    }

    /**
     * matches the sequence number and text representation of the command
     * @param value the sequence number in the enum
     * @return Text representation of the command
     */
    public static AdminCommands getIndex(int value){
        for (AdminCommands command: AdminCommands.values()){
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