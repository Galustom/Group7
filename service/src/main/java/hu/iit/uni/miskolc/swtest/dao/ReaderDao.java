package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;

import java.util.Collection;

public interface ReaderDao {

    Collection<Book> listBooks();
    Collection<Book> listAvailableBooks();
    void requestBook(Book book);
    Collection<Book> listBorrowings(Reader reader);
}