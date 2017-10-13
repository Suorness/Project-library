package com.bsuir.library.service;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.domain.Book;

import java.util.List;

public interface BookService {
    boolean addBook(String author, String title,int count,boolean eBook) throws ServiceException;
    Book findBook(String title, String author) throws ServiceException;
    boolean deleteBook(String author,String title) throws ServiceException;
    List<Book> findBooks(String param) throws ServiceException;
    List<Book> getBookList() throws ServiceException;
}