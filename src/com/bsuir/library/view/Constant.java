package com.bsuir.library.view;

public enum Constant {
    AddBook("Adding a book."),
    ChooseOperation("Enter operation number:"),
    SignUp("New User Registration"),
    SignIn("Sign in"),
    Exit("Exiting the program"),
    ShowList("Displaying a list of books"),
    Search("Search the catalog of books"),
    LogOut("Change user"),
    DelBook("Delete a book"),
    ErrorInput("An error occurred while entering the command, try again"),
    EnterLogin("Enter login"),
    EnterPassword("Enter password"),
    FileNotFound("File not found"),
    FileNameUserList("Users.txt"),
    SuccessReg("Successful registration"),
    FailReg("Registration fail"),
    FailAut("Authorisation fail"),
    SuccessAut("Successful authorization"),
    Ebook("Is there an electronic copy of the book?\n" +
            "1 - in stock\n" +
            "other characters - no inadvertently"),
    BookAuth("Enter the author of the book"),
    BookTitle("Enter book title"),
    BookCount("Enter the number of paper copies"),
    BookAdd("Book successfully added"),
    BookAddFail("Error adding book"),
    BookViewMode("Select an action:\n" +
            "1 - return to previous page\n" +
            "2 - next page\n" +
            "other - exit from the view mode"),
    BookEmpty("The book list is empty"),
    BookNotFount("Book not fount"),
    BookDelSuccess("Operation success"),
    BookDelFail("Operation fail");
    private String name;

    private Constant(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

