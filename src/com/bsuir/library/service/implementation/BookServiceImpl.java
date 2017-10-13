package com.bsuir.library.service.implementation;

import com.bsuir.library.dao.BookDAO;
import com.bsuir.library.dao.DAOFactory;
import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.Book;
import com.bsuir.library.service.BookService;
import com.bsuir.library.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing the mechanism of working with books
 */
public class BookServiceImpl implements BookService {

    public BookServiceImpl(){
        DAOFactory factory = DAOFactory.getInstance();
        bookDAO = factory.getBookDAO();
    }
    private BookDAO bookDAO;

    /**
     * Function of adding a book
     * @param author book author
     * @param title  book title
     * @param count  number of books
     * @param eBook presence of an electronic copy
     * @return true - added; false - not added
     * @throws ServiceException Thrown when in Service error occurs.
     */
    @Override
    public boolean addBook(String author, String title, int count, boolean eBook) throws ServiceException {
        boolean result = true;
        Book book = new Book(title,author,count,eBook);
        List<Book> list;
        try {
            list = bookDAO.getBookList();
        }
        catch (DAOException e){
            throw new   ServiceException(e);
        }
        for (Book checkBook: list){
            if ( (title.equals(checkBook.getTitle())) && (author.equals(checkBook.getAuthor())) ){
                result = false;
                break;
            }
        }
        if (result) {
            list.add(book);
            try {
                bookDAO.setBookList((ArrayList<Book>) list);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }

        return result;
    }
    /**
     * Book search function
     * @param title book title
     * @param author book author
     * @return  Instance of the book, if not found - null
     * @throws ServiceException Thrown when in Service error occurs.
     */
    @Override
    public Book findBook(String title, String author) throws ServiceException {
        List<Book> list;
        Book book = null;
        try {

            list = bookDAO.getBookList();

        } catch (DAOException e){
            throw new ServiceException(e);
        }
        for (Book checkBook: list){
            if ( (title.equals(checkBook.getTitle())) && (author.equals(checkBook.getAuthor())) ){
                book = checkBook;
                break;
            }
        }
        return book;
    }
    /**
     * Function of deleting a book
     * @param author book author
     * @param title book title
     * @return true - removed; false - not removed
     * @throws ServiceException Thrown when in Service error occurs.
     */
    @Override
    public boolean deleteBook(String author, String title) throws ServiceException {
        boolean result = false;
        List<Book> list;
        try {
            list = bookDAO.getBookList();
        } catch (DAOException e){
            throw new ServiceException(e);
        }
        for (Book checkBook: list) {
            if ((title.equals(checkBook.getTitle())) && (author.equals(checkBook.getAuthor()))) {
                list.remove(checkBook);
                result = true;
                break;
            }
        }
        try {
            bookDAO.setBookList((ArrayList<Book>) list);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
        return  result;
    }
    /**
     * The function of obtaining a list of books
     * @return list of book
     * @throws ServiceException Thrown when in Service error occurs.
     */
    @Override
    public List<Book> getBookList() throws ServiceException {
        List<Book> list;
        try {
            list = bookDAO.getBookList();
        }
        catch (DAOException e){
            throw new   ServiceException(e);
        }
        return  list;
    }
}