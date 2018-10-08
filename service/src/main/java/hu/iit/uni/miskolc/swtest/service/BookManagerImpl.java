package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.dao.BookDaoInterface;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookDoesNotExistException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BookManagerImpl implements BookManagerInterface {

    private BookDaoInterface bookDao;

    public BookManagerImpl(BookDaoInterface bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addBook(Book book) throws BookAlreadyAddedException {
        try {
            bookDao.createBook(book);
        }catch (BookEntryAlreadyAddedException e){
            throw new BookAlreadyAddedException(e);
        }
    }

    @Override
    public void updateBook(Book book) throws BookDoesNotExistException {
        try {
            bookDao.updateBook(book);
        }catch (BookEntryNotFoundException e){
            throw new BookDoesNotExistException(e);
        }
    }

    @Override
    public void deleteBook(Book book) throws BookDoesNotExistException {
        try {
            bookDao.deleteBook(book);
        }catch (BookEntryNotFoundException e){
            throw new BookDoesNotExistException(e);
        }
    }

    @Override
    public Collection<Book> listBooks() {
        return bookDao.readBooks();
    }

    @Override
    public Collection<Book> listBooksByGenre(String genre) {
        Set<Book> results = new HashSet<Book>();
        for(Book book : listBooks()){
            if (book.getGenre().equals(genre))
                results.add(book);
        }
        return results;
    }

    @Override
    public Collection<Book> listBooksByAuthor(String author) {
        Set<Book> results = new HashSet<Book>();
        for(Book book : listBooks()){
            if (book.getAuthor().equals(author))
                results.add(book);
        }
        return results;
    }

    @Override
    public Collection<Book> listBooksIfAvailable() {
        Set<Book> results = new HashSet<Book>();
        for(Book book : listBooks()){
            if (book.getAvailable() != 0)
                results.add(book);
        }
        return results;
    }
}
