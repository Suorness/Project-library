package com.bsuir.library.controller.command.implantation;
import com.bsuir.library.controller.command.Command;
import com.bsuir.library.domain.Book;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.implementation.ConsoleView;

import java.util.Scanner;

import static com.bsuir.library.view.Constant.*;

public class AddBookCommand implements Command{

    @Override
    public void execute(String request) {
        String author;
        String title;
        int count;
        boolean eBook = false;
        view.outputLine(BookAuth.getName());
        author = in.nextLine().trim();
        view.outputLine(BookTitle.getName());
        title = in.nextLine().trim();
        view.outputLine(Ebook.getName());
        String ebookStr = in.nextLine().trim();
        int eBookInt = Integer.parseInt(ebookStr);
        if (eBookInt == 1){
            eBook = true;
        }
        view.outputLine(BookCount.getName());
        count = Integer.parseInt(in.nextLine().trim());
        boolean result = true;
        try{
            ServiceFactory factory = ServiceFactory.getInstance();
            BookService bookService = factory.getBookService();
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
        view = new ConsoleView();
        in = new Scanner(System.in);
    }
    private ConsoleView view;
    private Scanner in;

}
