package com.bsuir.library.controller.command.implantation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.domain.Book;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.implementation.ConsoleView;

import java.util.Scanner;

import static com.bsuir.library.view.Constant.BookAuth;
import static com.bsuir.library.view.Constant.BookNotFount;
import static com.bsuir.library.view.Constant.BookTitle;

public class FindBookCommand implements Command{
    @Override
    public void execute(String request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();
        Book book = null;
        String title;
        String author;

        view.outputLine(BookAuth.getName());
        author = in.nextLine().trim();
        view.outputLine(BookTitle.getName());
        title = in.nextLine().trim();

        try {
            book = bookService.findBook(title,author);
        }catch (ServiceException e){
            view.showErrorInfo(e.getMessage());
        }
        if (book!=null){
            view.ShowBookInfo(book);
        }
        else{
            view.outputLine(BookNotFount.getName());
        }

    }
    public FindBookCommand(){
        view = new ConsoleView();
        in = new Scanner(System.in);
    }
    private ConsoleView view;
    private Scanner in;
}
