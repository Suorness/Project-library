package com.bsuir.library.view;

import com.bsuir.library.domain.Book;
import com.bsuir.library.domain.User.User;

import java.util.List;

/**
 * Interface intended for classes that display information
 */
public interface View {
    /**
     * displays a list of commands for the user type
     * @param userRole user role
     */
    void showListCommand(User.Role userRole);

    /**
     * displays a list of books
     * @param list  list of books
     */
    void showList(List<Book> list);

    /**
     * Displays book information
     * @param book  instanse book
     */
    void showBookInfo(Book book);

    /**
     * Prints a line of text
     * @param str String for output
     */
    void outputLine(String str);

    /**
     * Displays the error message
     * @param message error message
     */
    void showErrorInfo(String message);
}
