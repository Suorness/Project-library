package com.bsuir.library.view;
/**
 * Enumeration with persistent phrases
 */
public enum Constant {

    /**
     * Phrase of choice of action
     */
    ChooseOperation("Enter operation number:"),
    /**
     *  Sign Up
     */
    SignUp("New User Registration"),
    /**
     * Sign In
     */
    SignIn("Sign in"),
    /**
     * Exit
     */
    Exit("Exiting the program"),
    /**
     * Displaying a list of books
     */
    ShowList("Displaying a list of books"),
    /**
     * Search
     */
    Search("Search the catalog of books"),
    /**
     * Log Out
     */
    LogOut("Change user"),
    /**
     *  Input Error
     */
    ErrorInput("An error occurred while entering the command, try again"),
    /**
     * Enter login
     */
    EnterLogin("Enter login"),
    /**
     * Enter password
     */
    EnterPassword("Enter password"),
    /**
     * File not fount
     */
    FileNotFound("File not found"),
    /**
     * Name of the file with the list of users
     */
    FileNameUserList("Users.txt"),
    /**
     * Successful registration
     */
    SuccessReg("Successful registration"),
    /**
     *  Registration fail
     */
    FailReg("Registration fail"),
    /**
     * Authorisation fail
     */
    FailAut("Authorisation fail"),
    /**
     * Successful authorization
     */
    SuccessAut("Successful authorization"),
    /**
     * Adding a book
     */
    AddBook("Adding a book."),
    /**
     * Delete a book
     */
    DelBook("Delete a book"),
    /**
     * Retrieving e-book data
     */
    Ebook("Is there an electronic copy of the book?\n" +
            "1 - in stock\n" +
            "other characters - no inadvertently"),
    /**
     * Book author request
     */
    BookAuth("Enter the author of the book"),
    /**
     * Book title request
     */
    BookTitle("Enter book title"),
    /**
     * Book count request
     */
    BookCount("Enter the number of paper copies"),
    /**
     * message about adding a book
     */
    BookAdd("Book successfully added"),
    /**
     * message about not adding a book
     */
    BookAddFail("Error adding book"),
    /**
     * Selecting an action in the view mode
     */
    BookViewMode("Select an action:\n" +
            "1 - return to previous page\n" +
            "2 - next page\n" +
            "other - exit from the view mode"),
    /**
     * Reporting an empty list
     */
    BookEmpty("The book list is empty"),
    /**
     * Message about a book not found
     */
    BookNotFount("Book not fount"),
    /**
     * Reporting a successful operation
     */
    BookDelSuccess("Operation success"),
    /**
     * Reporting a fail operation
     */
    BookDelFail("Operation fail");
    private String name;

    Constant(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

