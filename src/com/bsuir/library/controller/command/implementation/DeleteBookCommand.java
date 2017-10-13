package com.bsuir.library.controller.command.implementation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.Reader;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;


import static com.bsuir.library.view.Constant.*;
/**
 * The class that implements the command interface allows you to delete book of catalog.
 */
public class DeleteBookCommand implements Command {
    /**
     * @see Command interface
     */
    @Override
    public void execute() {
        String author;
        String title;
        boolean result = true;
        view.outputLine(BookAuth.getName());
        author = reader.dataInputString();
        view.outputLine(BookTitle.getName());
        title = reader.dataInputString();

        try {
            result = bookService.deleteBook(title,author);
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
        ViewFactory factory = ViewFactory.getInstance();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        bookService = serviceFactory.getBookService();
        view  = factory.getView();
        reader = factory.getReader();

    }

    private BookService bookService;
    private View view;
    private Reader reader;
}
