package com.bsuir.library.dao.implementation;

import com.bsuir.library.dao.BookDAO;
import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.bsuir.library.view.Constant.FileNotFound;

/**
 * This is an object that provides information access to any type of database or storage mechanism.
 * @see BookDAO
 */
public class FileBookDAO implements BookDAO {
    private static final String PATH = System.getProperty("user.dir")+"/Books.txt";

    /**
     * @see BookDAO
     * @return List of books
     * @throws DAOException Thrown when in Data Access Object(DAO) error occurs.
     */
    @Override
    public List<Book> getBookList() throws DAOException {
        ArrayList<Book> list = null;
        File file = new File(PATH);
        if (file.length() == 0) {
            list = new ArrayList<>();
        } else {
            try (FileInputStream stream = new FileInputStream(PATH);
                 ObjectInputStream dataInStream = new ObjectInputStream(stream)) {
                list = (ArrayList<Book>) dataInStream.readObject();
            } catch (FileNotFoundException e) {
                throw new DAOException(FileNotFound.getName(), e);

            } catch (IOException | ClassNotFoundException e) {
                throw new DAOException(e);
            }

        }
        return list;
    }

    /**
     * @see BookDAO
     * @param list List of books
     * @throws DAOException Thrown when in Data Access Object(DAO) error occurs.
     */
    @Override
    public void setBookList(ArrayList<Book> list) throws DAOException {
        try(FileOutputStream stream = new FileOutputStream(PATH);
            ObjectOutputStream dataInStream = new ObjectOutputStream(stream)){
            dataInStream.writeObject(list);
            dataInStream.flush();
        } catch (FileNotFoundException e) {
            throw new DAOException(FileNotFound.getName(),e);
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }
}
