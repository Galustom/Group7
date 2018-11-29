package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.Collection;

public interface ReaderDao {

    Collection<Book> listBooks();

    Collection<Book> listAvailableBooks();

    void requestBook(Request request, Book book, Reader reader);

    Collection<Book> listBorrowings(Reader reader);
}