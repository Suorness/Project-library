package com.bsuir.library.domain;

public class Book implements  java.io.Serializable{
    public Book(){

    }
    public Book(String title, String author, int count, boolean eBook){
        this.title = title;
        this.author = author;
        this.count = count;
        id = generateId();
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean iseBook() {
        return eBook;
    }

    public void seteBook(boolean eBook) {
        this.eBook = eBook;
    }


    private int generateId(){
        int result=17;
        result = 31 * title.hashCode() + author.hashCode();
        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        final int prime = 31;
        result = prime * result + title.hashCode();
        result = prime * result + author.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        Book bookOnCheck = (Book) obj;
        if (title == null) {
            if (bookOnCheck.title != null) {
                return false;
            }
        } else if (!title.equals(bookOnCheck.title)) {
            return false;
        }
        if (author == null ) {
            if (bookOnCheck.author != null){
                return false;
            }
        } else if (!author.equals(bookOnCheck.author)) {
            return false;
        }
        return true;
    }


    private String author;
    private String title;
    private int id;
    private int count;
    private boolean eBook;


}
