package com.bsuir.library.dao;

import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * The BookDAO interface should be implemented by any class whose instances are intended
 * to be provides an interface to any type of database or storage engine.
 * Designed to obtain a catalog of books
 */
public interface BookDAO {
    /**
     * Gets a list of books from DAO
     * @return List of books
     * @throws DAOException Thrown when in Data Access Object(DAO) error occurs.
     */
    List<Book> getBookList() throws DAOException;

    /**
     * Sets the list of books in DAO
     * @param list List of books
     * @throws DAOException Thrown when in Data Access Object(DAO) error occurs.
     */
    void setBookList(ArrayList<Book> list) throws DAOException;

}
