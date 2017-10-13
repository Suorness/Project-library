package com.bsuir.library.controller.command.implantation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.domain.Book;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.implementation.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import static com.bsuir.library.view.Constant.BookEmpty;
import static com.bsuir.library.view.Constant.BookViewMode;

public class BrowseBookCatalogCommand implements Command {
    @Override
    public void execute(String request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();
        List<Book> list;
        boolean viewMode = true;
        try{
            list = bookService.getBookList();
            if (list.size()!=0) {
                int numPage = 0;
                List<List<Book>> pages = pagination(list);
                List<Book> page = pages.get(numPage);
                while (viewMode) {
                    view.showList(page);
                    view.outputLine(BookViewMode.getName());
                    int num = Integer.parseInt(in.nextLine());
                    switch (num) {
                        case 1:
                            if (numPage>0) {
                                numPage--;
                                page = pages.get(numPage);
                            }
                            break;
                        case 2:
                            if (numPage+1<pages.size()) {
                                numPage++;
                                page = pages.get(numPage);
                            }
                            break;
                        default:
                            viewMode = false;
                    }
                }
            }
            else{
                view.outputLine(BookEmpty.getName());
            }

        }catch (ServiceException e){
            view.showErrorInfo(e.getMessage());
        }

    }

    private ConsoleView view;
    private Scanner in;
    public BrowseBookCatalogCommand(){
        view = new ConsoleView();
        in = new Scanner(System.in);
    }

    private int countBookOnPage = 2;

    private List<List<Book>>  pagination (List<Book> list){
        List<List<Book>> pages = new ArrayList<List<Book>>();
        for (int i = 0; i < list.size(); i += countBookOnPage) {
            List<Book> page = list.subList(i, Math.min(i + countBookOnPage, list.size()));
            pages.add(page);
        }
        return pages;
    }
}
