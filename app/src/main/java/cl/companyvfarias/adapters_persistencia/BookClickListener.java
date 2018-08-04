package cl.companyvfarias.adapters_persistencia;

import java.io.Serializable;

import cl.companyvfarias.adapters_persistencia.models.Book;

public interface BookClickListener {
    void clickedID(long id);
    public void sendData(Book book);
}
