package com.bsuir.library.view.implementation;

import com.bsuir.library.domain.Book;
import com.bsuir.library.domain.User;
import com.bsuir.library.view.View;

import java.util.List;


import static com.bsuir.library.view.Constant.*;

public class ConsoleView implements View {

    public enum GuestCommands{
        SIGNUP(0,SignUp.getName()),SIGNIN(1, SignIn.getName()),EXIT(2, Exit.getName());

        private int index;
        private String name;
        GuestCommands(int value,String name){
            index=value;
            this.name=name;
        }
        public static GuestCommands getIndex(int value){
            for (GuestCommands command: GuestCommands.values()){
                if (value==command.getIndex()){
                    return command;
                }
            }
            return null;

        }
        public String getCommandName(){
            return name;
        }

        public int getIndex() {
            return index;
        }

    }
    public enum AdminCommands{
        SHOWLIST(0,ShowList.getName()),SEARCH(1, Search.getName()),LOGOUT(2,LogOut.getName()),
                ADDBOOK(3,AddBook.getName()),DELBOOK(4,DelBook.getName()),EXIT(5, Exit.getName());

        private int index;
        private String name;
        AdminCommands(int value,String name){
            index=value;
            this.name=name;
        }
        public static AdminCommands getIndex(int value){
            for (AdminCommands command: AdminCommands.values()){
                if (value==command.getIndex()){
                    return command;
                }
            }
            return null;

        }
        public String getCommandName(){
            return name;
        }

        public int getIndex() {
            return index;
        }

    }
    public enum UserCommands{
        SHOWLIST(0,ShowList.getName()),SEARCH(1, Search.getName()),LOGOUT(2,LogOut.getName()),EXIT(3, Exit.getName());

        private int index;
        private String name;
        UserCommands(int value,String name){
            index=value;
            this.name=name;
        }
        public static UserCommands getIndex(int value){
            for (UserCommands command: UserCommands.values()){
                if (value==command.getIndex()){
                    return command;
                }
            }
            return null;

        }
        public String getCommandName(){
            return name;
        }

        public int getIndex() {
            return index;
        }

    }

    @Override
    public void showListCommand(User.Role userRole){
        String resultString=ChooseOperation.getName() + "\r\n";
        switch (userRole) {
            case GUEST:
                for (GuestCommands command : GuestCommands.values()) {
                    resultString += command.getIndex() + ": " + command.getCommandName() +"\r\n";
                }
                break;
            case USER:
                for (UserCommands command : UserCommands.values()) {
                    resultString += command.getIndex() + ": " + command.getCommandName()+"\r\n";
                }
                break;
            case ADMIN:
                for (AdminCommands command : AdminCommands.values()) {
                    resultString += command.getIndex() + ": " + command.getCommandName()+"\r\n";
                }
                break;
        }
        outputLine(resultString);

    }
    @Override
    public void showList(List<Book>  list){
        String resultOutPut = "";
        for (Book book: list){
            resultOutPut +=  book.getTitle() +  " " + book.getAuthor() + " " +
                    book.getCount() + "\r\n";
        }
        outputLine(resultOutPut);

    }
    @Override
    public void ShowBookInfo(Book book){
        String resultOutPut = "";
        resultOutPut +=  book.getTitle() +  " " + book.getAuthor() + "  count: " +
                book.getCount() + "\r\n";
        outputLine(resultOutPut);
    }
    @Override
    public void outputLine(String str){
        System.out.println(str);
    }
    @Override
    public void showErrorInfo(String message ){
        System.err.println(message);
    }
}
