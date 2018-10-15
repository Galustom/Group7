package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;

import java.util.Collection;

//READ IT!
//Tips:
//This interface should be implemented using the methods from BookManagerInterface, they are already implemented
//so its easier to use them trough BookManagerInterface, less work for you yeaaa!
public interface ReaderManagerInterface {

    Collection<Book> listBooks();  //example here, you can just use the
                                    //already written method(listBooks()) from BookManagerInterface

    Collection<Book> listAvailableBooks();
    void requestBook(Book book);
    Collection<Book> listBorrowings(Reader reader);

}

