package com.bsuir.library.view.implementation;

import com.bsuir.library.domain.Book;
import com.bsuir.library.domain.User.RoleCommands.AdminCommands;
import com.bsuir.library.domain.User.RoleCommands.GuestCommands;
import com.bsuir.library.domain.User.RoleCommands.UserCommands;
import com.bsuir.library.domain.User.User;
import com.bsuir.library.view.View;

import java.util.List;


import static com.bsuir.library.view.Constant.*;

public class ConsoleView implements View {
    /**
     * displays a list of commands for the user type
     * @param userRole user role
     */
    @Override
    public void showListCommand(User.Role userRole){
        String resultString=ChooseOperation.getName() + "\r\n";
        switch (userRole) {
            case GUEST:
                for (GuestCommands command : GuestCommands.values()) {
                    resultString += command.getIndex() + ": " + command.getCommandName() +"\r\n";
                }
                break;
            case USER:
                for (UserCommands command : UserCommands.values()) {
                    resultString += command.getIndex() + ": " + command.getCommandName()+"\r\n";
                }
                break;
            case ADMIN:
                for (AdminCommands command : AdminCommands.values()) {
                    resultString += command.getIndex() + ": " + command.getCommandName()+"\r\n";
                }
                break;
        }
        outputLine(resultString);

    }
    /**
     * displays a list of books
     * @param list  list of books
     */
    @Override
    public void showList(List<Book>  list){
        String resultOutPut = "";
        for (Book book: list){
            resultOutPut +=  book.getTitle() +  " " + book.getAuthor() + " " +
                    book.getCount() + "\r\n";
        }
        outputLine(resultOutPut);

    }
    /**
     * Displays book information
     * @param book  instanse book
     */
    @Override
    public void showBookInfo(Book book){
        String resultOutPut = "";
        resultOutPut +=  book.getTitle() +  " " + book.getAuthor() + "  count: " +
                book.getCount() + "\r\n";
        outputLine(resultOutPut);
    }

    /**
     * Prints a line of text
     * @param str String for output
     */
    @Override
    public void outputLine(String str){
        System.out.println(str);
    }
    /**
     * Displays the error message
     * @param message error message
     */
    @Override
    public void showErrorInfo(String message ){
        System.err.println(message);
    }
}
