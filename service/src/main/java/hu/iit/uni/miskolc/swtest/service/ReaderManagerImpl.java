package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.dao.ReaderDao;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;

import java.util.Collection;

public class ReaderManagerImpl implements ReaderManager {

    ReaderDao readerDAO;

    public ReaderManagerImpl(ReaderDao readerDAO){
        this.readerDAO = readerDAO;
    }

    @Override
    public Collection<Book> listBooks() {
        return readerDAO.listBooks();
    }

    @Override
    public Collection<Book> listAvailableBooks() {
        return  readerDAO.listAvailableBooks();
    }

    @Override
    public void requestBook(Book book) {
        readerDAO.requestBook(book);
    }

    @Override
    public Collection<Book> listBorrowings(Reader reader) {
        return readerDAO.listBorrowings(reader);
    }
}