package com.bsuir.library.domain.User.RoleCommands;


import static com.bsuir.library.view.Constant.Exit;
import static com.bsuir.library.view.Constant.SignIn;
import static com.bsuir.library.view.Constant.SignUp;
/**
 * Enumeration providing access to the list of guest commands
 */
public enum GuestCommands{
    /**
     * Sign Up
     */
    SIGNUP(0,SignUp.getName()),
    /**
     * Sign In
     */
    SIGNIN(1, SignIn.getName()),
    /**
     * Exit
     */
    EXIT(2, Exit.getName());

    private int index;
    private String name;
    GuestCommands(int value,String name){
        index=value;
        this.name=name;
    }
    /**
     * matches the sequence number and text representation of the command
     * @param value the sequence number in the enum
     * @return Text representation of the command
     */
    public static GuestCommands getIndex(int value){
        for (GuestCommands command: GuestCommands.values()){
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
