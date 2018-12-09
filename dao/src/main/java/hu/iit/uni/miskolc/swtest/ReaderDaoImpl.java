package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.ReaderDao;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static hu.iit.uni.miskolc.swtest.BookDaoImpl.readAllBook;
import static hu.iit.uni.miskolc.swtest.RequestDaoImpl.ReadAllRequest;

public class ReaderDaoImpl implements ReaderDao {

    @Override
    public Collection<Book> listBooks() {
        Collection<Book> books = readAllBook();
        return books;
    }

    @Override
    public Collection<Book> listAvailableBooks() {
        Collection<Book> books = readAllBook();
        Collection<Book> availableBooks = new ArrayList<>();

        for (Book bookItem : books) {
            if (bookItem.getAvailable()>0)
            {availableBooks.add(bookItem);}
        }
        
        return availableBooks;
    }

    @Override
    public void requestBook(Request request, Book book, Reader reader) {
        //TODO IMPLEMENT THIS
        Request newRequest = new Request(request.getId(), book.getId(),reader.getId());
    }

    @Override
    public Collection<Book> listBorrowings(Reader reader) {
        return reader.getBorrowings().getBorrowedBooks();
    }
}

