package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;

import java.util.Collection;

//READ IT!
//Tips:
//This interface should be implemented using the methods from BookManager, they are already implemented
//so its easier to use them trough BookManager, less work for you yeaaa!
public interface ReaderManager {

    Collection<Book> listBooks();  //example here, you can just use the
                                    //already written method(listBooks()) from BookManager

    Collection<Book> listAvailableBooks();
    void requestBook(Book book);
    Collection<Book> listBorrowings(Reader reader);

}

