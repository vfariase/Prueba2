package cl.companyvfarias.adapters_persistencia.models;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Book extends SugarRecord implements Serializable{

    String author,title,description,isbn;
    public boolean available;

    public Book() {
    }

    public Book(String author, String title, String description, String isbn, boolean available) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.available = available;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

