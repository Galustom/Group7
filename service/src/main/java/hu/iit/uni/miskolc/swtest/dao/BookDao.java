package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.exceptions.IdNotValidException;

import java.util.Collection;

/**
 * Interface to use Book objects from database.
 */
public interface BookDao {


    /**
     * Should get a book object and save it to database.
     * @param book book
     * @throws BookEntryAlreadyAddedException
     */
    void createBook(Book book) throws BookEntryAlreadyAddedException;

    /**
     * Get all books from database to a collection.
     * @return
     */
    Collection<Book> readBooks();

    /**
     * Get a book in parameter and update to the book by book.Id in database.
     * @param book The book what we want to refresh in database.
     * @throws BookEntryNotFoundException throw this exception if book is not found.
     */
    void updateBook(Book book) throws BookEntryNotFoundException, IdNotValidException;

    /**
     * Delete the specified book.
     * @param book book object
     * @throws BookEntryNotFoundException
     */
    void deleteBook(Book book) throws BookEntryNotFoundException;
}
