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
 * The class that implements the command interface allows you to add books.
 */
public class AddBookCommand implements Command{

    /**
     * @see Command interface
     */
    @Override
    public void execute() {
        String author;
        String title;
        int count;
        boolean eBook = false;
        view.outputLine(BookAuth.getName());
        author = reader.dataInputString();
        view.outputLine(BookTitle.getName());
        title = reader.dataInputString();
        view.outputLine(Ebook.getName());
        int eBookInt = reader.dataInputInt();
        if (eBookInt == 1){
            eBook = true;
        }
        view.outputLine(BookCount.getName());
        count = reader.dataInputInt();
        if (count<0){
            count = 0;
        }
        boolean result = true;
        try{
            result = bookService.addBook(author,title,count,eBook);
        }catch (ServiceException e){
            view.showErrorInfo(e.getMessage());
        }
        if (result){
            view.outputLine(BookAdd.getName());
        }
        else
        {
            view.outputLine(BookAddFail.getName());
        }

    }

    public AddBookCommand(){
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
