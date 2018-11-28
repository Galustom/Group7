package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.exceptions.IdNotValidException;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookDoesNotExistException;

import java.util.Collection;
import java.util.Date;

public interface LibrarianManager {

    Collection<Book> listBooks();

    Collection<Request> listReaderRequests(Reader reader);

    void addBookToLibrary(Book book) throws BookAlreadyAddedException;

    void updateBook(Book book) throws BookDoesNotExistException;

    void deleteBook(Book book) throws BookDoesNotExistException;

    Collection<Book> listBooksByGenre(String genre);

    Collection<Book> listBooksByAuthor(String author);

    Collection<Book> listBooksIfAvailable();

    Collection<Book> listReaderBorrowings(Reader reader);

    //Collection<RequestManager> listReaderRequests(Reader reader);
    void fulfillRequest(Reader reader);

    void setRequest(Book book, Reader reader);

    void approve(int requestId, Date date) throws IdNotValidException;

    void setRequestedBooks(Collection<Book> requestedBooks);
}
