package com.bsuir.library.view;

import com.bsuir.library.domain.Book;
import com.bsuir.library.domain.User;

import java.util.List;

public interface View {

    void showListCommand(User.Role userRole);
    void showList(List<Book> list);
    void ShowBookInfo(Book book);
    void outputLine(String str);
    void showErrorInfo(String message);
}
