package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.Collection;

//READ IT!
//Tips:
//This interface should be implemented using the methods from BookManagerInterface, they are already implemented
//so its easier to use them trough BookManagerInterface, less work for you yeaaa!
public interface LibrarianManagerInterface {

    Collection<Book> listBooks();  //example here, you can just use the
                                    //already written method(listBooks()) from BookManagerInterface

    void addBookToLibrary(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
    Collection<Book> listReaderBorrowings(Reader reader);
    Collection<Request> listReaderRequests(Reader reader);
    void fulfillRequest(Reader reader);

}
