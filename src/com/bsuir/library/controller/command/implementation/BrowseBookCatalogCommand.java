package com.bsuir.library.controller.command.implementation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.domain.Book;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.view.Reader;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;


import java.util.ArrayList;
import java.util.List;


import static com.bsuir.library.view.Constant.BookEmpty;
import static com.bsuir.library.view.Constant.BookViewMode;

/**
 * The class that implements the command interface allows you to display the book catalog.
 */
public class BrowseBookCatalogCommand implements Command {
    /**
     *@see Command interface
     */
    @Override
    public void execute() {
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
                    int num = reader.dataInputInt();
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

    private BookService bookService;
    private View view;
    private Reader reader;

    public BrowseBookCatalogCommand(){
        ViewFactory factory = ViewFactory.getInstance();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        bookService = serviceFactory.getBookService();
        view  = factory.getView();
        reader = factory.getReader();

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
