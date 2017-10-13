package com.bsuir.library.service;
import com.bsuir.library.service.exception.ServiceException;
import com.bsuir.library.domain.Book;

import java.util.List;

/**
 * The BookService should be implemented by any class that provides access to work with book
 */
public interface BookService {
    /**
     * Function of adding a book
     * @param author book author
     * @param title  book title
     * @param count  number of books
     * @param eBook presence of an electronic copy
     * @return true - added; false - not added
     * @throws ServiceException Thrown when in Service error occurs.
     */
    boolean addBook(String author, String title,int count,boolean eBook) throws ServiceException;

    /**
     * Book search function
     * @param title book title
     * @param author book author
     * @return  Instance of the book, if not found - null
     * @throws ServiceException Thrown when in Service error occurs.
     */
    Book findBook(String title, String author) throws ServiceException;

    /**
     * Function of deleting a book
     * @param author book author
     * @param title book title
     * @return true - removed; false - not removed
     * @throws ServiceException Thrown when in Service error occurs.
     */
    boolean deleteBook(String author,String title) throws ServiceException;

    /**
     * The function of obtaining a list of books
     * @return list of book
     * @throws ServiceException Thrown when in Service error occurs.
     */
    List<Book> getBookList() throws ServiceException;
}