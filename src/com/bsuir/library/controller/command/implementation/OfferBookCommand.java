package com.bsuir.library.controller.command.implementation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.domain.Book;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.MailService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.view.Reader;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;

import static com.bsuir.library.view.Constant.*;

public class OfferBookCommand implements Command {
    @Override
    public void execute() {
        String author;
        String title;
        view.outputLine(BookAuth.getName());
        author = reader.dataInputString();
        view.outputLine(BookTitle.getName());
        title = reader.dataInputString();
        mailService.offerBook(new Book(title,author,0,false));
    }
    public OfferBookCommand(){
        ViewFactory factory = ViewFactory.getInstance();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        mailService = serviceFactory.getMailService();
        view  = factory.getView();
        reader = factory.getReader();
    }
    private MailService mailService;
    private View view;
    private Reader reader;
}
