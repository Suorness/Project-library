package com.bsuir.library.dao;

import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookDAO {

    boolean addBook(Book book) throws DAOException;

    Book findBook(String title) throws DAOException;

    boolean deleteBook(int idBook) throws DAOException;

    List<Book> getBookList() throws DAOException;
    void setBookList(ArrayList<Book> list) throws DAOException;

}
