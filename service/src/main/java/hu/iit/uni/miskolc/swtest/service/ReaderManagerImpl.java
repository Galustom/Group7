package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.dao.ReaderDao;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.Collection;

public class ReaderManagerImpl implements ReaderManager {

    ReaderDao readerDAO;

    public ReaderManagerImpl(ReaderDao readerDAO) {
        this.readerDAO = readerDAO;
    }

    @Override
    public Collection<Book> listBooks() {
        return readerDAO.listBooks();
    }

    @Override
    public Collection<Book> listAvailableBooks() {
        return readerDAO.listAvailableBooks();
    }

    @Override
    public void requestBook(Request request, Book book, Reader reader) {
        readerDAO.requestBook(request, book, reader);
    }

    @Override
    public Collection<Book> listBorrowings(Reader reader) {
        return readerDAO.listBorrowings(reader);
    }
}