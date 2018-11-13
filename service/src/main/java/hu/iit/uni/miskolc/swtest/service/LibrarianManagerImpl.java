package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.dao.BookDao;
import hu.iit.uni.miskolc.swtest.dao.ReaderDao;
import hu.iit.uni.miskolc.swtest.dao.RequestDao;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookDoesNotExistException;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LibrarianManagerImpl implements LibrarianManager {

    private BookDao librarianManagerDAO;
    private RequestDao requestDao;
    private ReaderDao readerDao;

    public LibrarianManagerImpl (BookDao librarianManagerDAO) {this.librarianManagerDAO = librarianManagerDAO;}

    @Override
    public Collection<Book> listBooks() {
        return librarianManagerDAO.readBooks();
    }

    @Override
    public Collection<Request> listReaderRequests(Reader reader) {
        return requestDao.readRequests();
    }

    @Override
    public void addBookToLibrary(Book book) throws BookAlreadyAddedException
    {
        try{
            librarianManagerDAO.createBook( book );
        }
        catch (BookEntryAlreadyAddedException e)
        {
            throw new BookAlreadyAddedException(e);
        }
    }

    @Override
    public void updateBook(Book book) throws BookDoesNotExistException{
        try{
            librarianManagerDAO.updateBook(book);
        }
        catch (BookEntryNotFoundException e)
        {
            throw new BookDoesNotExistException(e);
        }

    }

    @Override
    public void deleteBook(Book book) throws BookDoesNotExistException {
        try {
            librarianManagerDAO.deleteBook(book);
        }
        catch (BookEntryNotFoundException e)
        {
            throw new BookDoesNotExistException(e);
        }
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

    @Override
    public Collection<Book> listReaderBorrowings(Reader reader){
        return readerDao.listBorrowings(reader);
    }

    //public Collection<RequestManager> listReaderRequests(Reader reader) { }
    public  void fulfillRequest(Reader reader){
        //TODO implement
    }

    @Override
    public void setRequest(Book book, Reader reader) {
        // TODO: implement
    }

    @Override
    public void approve(int requestId, Date date) {
        Request requestBook = requestDao.GetRequest(requestId);
        requestBook.setApprove(true);
        requestBook.setApprovalLibrarianId(1); //Need to implement getCurrentLibrarian()
    }

    @Override
    public void setRequestedBooks(Collection<Book> requestedBooks) {
        // TODO: implement
    }
}


