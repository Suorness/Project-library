package com.bsuir.library.service.implementation;

import com.bsuir.library.dao.DAOFactory;
import com.bsuir.library.dao.UserDAO;
import com.bsuir.library.dao.exception.DAOException;
import com.bsuir.library.domain.User.User;
import com.bsuir.library.service.UserService;
import com.bsuir.library.service.exception.ServiceException;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing the mechanism of working with users
 */
public class UserServiceImpl implements UserService {


    public static UserServiceImpl getInstance() {
        return instance;
    }
    /**
     * User Registration Function
     * @param login user login
     * @param password user password
     * @return true - registered, false - not registered
     * @throws ServiceException Thrown when in Service error occurs.
     */
    @Override
    public boolean register(String login, String password) throws ServiceException {

        User user = new User(login,getHash(password),User.Role.USER);
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        List<User> list;
        try{
            list = userDAO.getUserList();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(),e); //TODO:
        }
        for (User item: list){
            if (item.equals(user)){
                return false;
            }
        }
        list.add(user);
        try {
            userDAO.setUserList((ArrayList<User>)list);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
        return true;
    }
    /**
     * Login function
     * @param login user login
     * @param password user password
     * @return true - logged in, false - not logged in
     * @throws ServiceException Thrown when in Service error occurs.
     */
    @Override
    public boolean logIn(String login, String password) throws ServiceException {
        boolean result = false;
        String hashValue = getHash(password);
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        List<User> list;
        try{
            list = userDAO.getUserList();
        }catch (DAOException e){
            throw new ServiceException(e);
        }

        int index = list.indexOf(new User(login,hashValue));
        if (index!= -1){
            user = list.get(index);
            result = true;
        }
        return result;

    }
    /**
     *  Sign Out
     * @throws ServiceException Thrown when in Service error occurs.
     */
    @Override
    public void logOut() throws ServiceException {
        user = null;
    }

    public User.Role getCurrentRole(){
        if (user==null){
            return User.Role.GUEST;
        }
        else
            return user.getRole();
    }
    private String getHash(String string){
        MessageDigest md = null;
        String hashValue="";
        try {
            md = MessageDigest.getInstance ("MD5");
            md.update(string.getBytes());
            hashValue = DatatypeConverter.printHexBinary(md.digest()).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }finally {
            return hashValue;
        }

    }

    private User user = null;
    private static UserServiceImpl instance = new UserServiceImpl();
}
