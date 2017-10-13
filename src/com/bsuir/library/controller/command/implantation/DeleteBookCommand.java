package com.bsuir.library.controller.command.implantation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.implementation.ConsoleView;

import java.util.Scanner;

import static com.bsuir.library.view.Constant.*;

public class DeleteBookCommand implements Command {
    @Override
    public void execute(String request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();
        String author;
        String title;
        boolean result = true;
        view.outputLine(BookAuth.getName());
        author = in.nextLine().trim();
        view.outputLine(BookTitle.getName());
        title = in.nextLine().trim();

        try {
            bookService.deleteBook(title,author);
        }catch (ServiceException e){
            view.showErrorInfo(e.getMessage());
        }
        if (result){
            view.outputLine(BookDelSuccess.getName());
        }
        else{
            view.outputLine(BookDelFail.getName());
        }
    }

    public DeleteBookCommand(){
        view = new ConsoleView();
        in = new Scanner(System.in);
    }
    private ConsoleView view;
    private Scanner in;
}
