package com.bsuir.library.service.implementation;

import com.bsuir.library.domain.Book;
import com.bsuir.library.domain.User.User;
import com.bsuir.library.service.MailService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.service.UserService;
import com.bsuir.library.service.exception.ServiceException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class MailServiceImpl implements MailService {
    private static MailServiceImpl ourInstance = new MailServiceImpl();

    private static final String SETTINGS = "/resources/setting.properties";
    private Properties props;
    private Session session;
    public static MailServiceImpl getInstance() {
        return ourInstance;
    }
    private MailServiceImpl() {
        props = new Properties();

        try {
            props.load(MailServiceImpl.class.getResourceAsStream(SETTINGS));
        } catch (IOException e){

        }

        final String username = props.getProperty("mail.smtp.username");
        final String password = props.getProperty("mail.smtp.pass");

        session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }
    @Override
    public void sendNotify() {
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        List<User> list = null;
        try {
            list = userService.getUserList();
        } catch (ServiceException e) {

        }
        for (User user: list) {
            if(!user.getEmail().isEmpty()){
                Thread thread = new Thread(() -> {
                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(props.getProperty("mail.smtp.username")));
                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(user.getEmail()));
                        message.setSubject(props.getProperty("email.addBook.subject"));
                        message.setText(String.format(props.getProperty("email.addBook.message"),"Update in library"));
                        Transport.send(message);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                });

                thread.start();
            }
        }
    }


    @Override
    public void offerBook(Book book) {
        Thread thread = new Thread(() -> {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(props.getProperty("mail.smtp.username")));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(props.getProperty("AdminAdress")));
                message.setSubject(props.getProperty("email.addBook.subject"));
                message.setText(String.format(props.getProperty("email.offerBook.message"),
                        book.getTitle(),
                        book.getAuthor()));
                Transport.send(message);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
    }
}
