package com.bsuir.library.dao.implementation;

import com.bsuir.library.dao.UserDAO;
import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.User;

import java.io.*;
import java.util.ArrayList;

import static com.bsuir.library.view.Constant.FileNameUserList;
import static com.bsuir.library.view.Constant.FileNotFound;

public class FileUserDAO implements UserDAO {
    private static final String PATH = System.getProperty("user.dir")+"/"+ FileNameUserList.getName();
    @Override
    public boolean register(User user) throws DAOException {
        return false;
    }

    @Override
    public boolean logination(String login, String password) throws DAOException {
        return false;
    }

    @Override
    public ArrayList<User> getUserList() throws DAOException {
        ArrayList<User> list = null;
        File file = new File(PATH);
        if(file.length()== 0){
            list = new ArrayList<>();
        }
        else {
            try (FileInputStream stream = new FileInputStream(PATH);
                 ObjectInputStream dataInStream = new ObjectInputStream(stream)) {
                list = (ArrayList<User>) dataInStream.readObject();
            } catch (FileNotFoundException e) {
                throw new DAOException(FileNotFound.getName(), e);

            } catch (IOException |  ClassNotFoundException e) {
                throw new DAOException(e.getMessage());
            }

        }
        return list;
    }

    @Override
    public void setUserList(ArrayList<User> list) throws DAOException {
        try(FileOutputStream stream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)){

            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
        } catch (FileNotFoundException exc) {
            throw new DAOException(FileNotFound.getName(),exc);

        } catch (IOException exc) {
            throw new DAOException(exc);
        }
    }

}
