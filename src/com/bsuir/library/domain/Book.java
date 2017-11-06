package com.bsuir.library.domain;

import com.bsuir.library.domain.User.User;

/**
 * This class summarizes the information about the book
 */
public class Book implements  java.io.Serializable{
    public Book(){

    }
    public Book(String title, String author, int count, boolean eBook){
        this.title = title;
        this.author = author;
        this.count = count;
        id = generateId();
    }

    /**
     * Getting the title of a book
     * @return title of book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setting the title of a book
     * @param title title of book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getting the author of a book
     * @return author of book
     */
    public String getAuthor() {
        return author;
    }

    /**
     *  Setting the author of a book
     * @param author  author of a book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getting id of book
     * @return id Index of the book
     */
    public int getId() {
        return id;
    }

    /**
     *  Getting count book
     * @return Count of book
     */
    public int getCount() {
        return count;
    }

    /**
     * Setting count book
     * @param count Count of book
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Determines the presence of an e-book
     * @return availability of e-book
     */
    public boolean iseBook() {
        return eBook;
    }

    /**
     * sets the availability of an e-book
     * @param eBook availability of e-book
     */
    public void seteBook(boolean eBook) {
        this.eBook = eBook;
    }


    private int generateId(){
        int result=17;
        result = 31 * title.hashCode() + author.hashCode();
        return result;
    }

    /**
     * Calculates the hash value of a function
     * @return value of the hash function
     */
    @Override
    public int hashCode() {
        int result = 17;
        final int prime = 31;
        result = prime * result + title.hashCode();
        result = prime * result + author.hashCode();
        return result;
    }

    /**
     * Compares objects
     * @param obj  object to compare
     * @return comparison result
     */
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
