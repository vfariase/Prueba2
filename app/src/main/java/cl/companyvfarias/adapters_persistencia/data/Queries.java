package cl.companyvfarias.adapters_persistencia.data;

import java.util.ArrayList;
import java.util.List;

import cl.companyvfarias.adapters_persistencia.models.Book;

public class Queries {

    public List<Book> books(){

        List<Book> book =new ArrayList<>();
        List<Book> booksList = Book.find(Book.class,"available=0");


        if(booksList != null && booksList.size()>0)
        {
            book.addAll(booksList);
        }
        return book;
    }
}
