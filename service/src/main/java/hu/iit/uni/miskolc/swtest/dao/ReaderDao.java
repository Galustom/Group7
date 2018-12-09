package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.Collection;

/**
 * Interface to use Reader objects from database.
 */

public interface ReaderDao {

    /**
     *
     * List of all books
     * @return
     */

    Collection<Book> listBooks();

    /**
     *
     *List of all availbable books
     * @return
     */

    Collection<Book> listAvailableBooks();

    /**
     *
     * list of requested book(s)
     * @param request
     * @param book
     * @param reader
     */

    void requestBook(Request request, Book book, Reader reader);

    /**
     *
     * List of the borrowed books
     * @param reader
     * @return
     */
    Collection<Book> listBorrowings(Reader reader);
}