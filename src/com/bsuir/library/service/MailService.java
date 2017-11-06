package com.bsuir.library.service;

import com.bsuir.library.domain.Book;

public interface MailService {
    void sendNotify();
    void offerBook(Book book);
}
