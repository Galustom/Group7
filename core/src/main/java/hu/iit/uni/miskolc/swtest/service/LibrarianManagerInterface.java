package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;
<<<<<<< HEAD
=======
import hu.iit.uni.miskolc.swtest.service.exceptions.BookAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookDoesNotExistException;
>>>>>>> origin/Implementation-of-LibrarianManagerInterface-#12

import java.util.Collection;

//READ IT!
//Tips:
//This interface should be implemented using the methods from BookManagerInterface, they are already implemented
//so its easier to use them trough BookManagerInterface, less work for you yeaaa!
public interface LibrarianManagerInterface {

    Collection<Book> listBooks();  //example here, you can just use the
<<<<<<< HEAD
                                    //already written method(listBooks()) from BookManagerInterface

    void addBookToLibrary(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
    Collection<Book> listReaderBorrowings(Reader reader);
    Collection<Request> listReaderRequests(Reader reader);
=======
    //already written method(listBooks()) from BookManagerInterface

    void addBookToLibrary(Book book) throws BookAlreadyAddedException;
    void updateBook(Book book) throws BookDoesNotExistException;
    void deleteBook(Book book) throws BookDoesNotExistException;
    Collection<Book> listBooksByGenre(String genre);
    Collection<Book> listBooksByAuthor(String author);
    Collection<Book> listBooksIfAvailable();

    Collection<Book> listReaderBorrowings(Reader reader);
    //Collection<Request> listReaderRequests(Reader reader);
>>>>>>> origin/Implementation-of-LibrarianManagerInterface-#12
    void fulfillRequest(Reader reader);

}
