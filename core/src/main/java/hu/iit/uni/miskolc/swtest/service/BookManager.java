package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookDoesNotExistException;

import java.util.Collection;

public interface BookManager {

    void addBook(Book book) throws BookAlreadyAddedException;
    void updateBook(Book book) throws BookDoesNotExistException;
    void deleteBook(Book book) throws BookDoesNotExistException;
    Collection<Book> listBooks();
    Collection<Book> listBooksByGenre(String genre);
    Collection<Book> listBooksByAuthor(String author);
    Collection<Book> listBooksIfAvailable();
}
