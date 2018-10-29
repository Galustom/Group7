package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.model.Book;

import java.util.Collection;

public interface BookDao {

    void createBook(Book book) throws BookEntryAlreadyAddedException;
    Collection<Book> readBooks();
    void updateBook(Book book) throws BookEntryNotFoundException;
    void deleteBook(Book book) throws BookEntryNotFoundException;
}
