package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.service.exceptions.BookDoesNotExistException;

import hu.iit.uni.miskolc.swtest.service.LibrarianManagerInterface;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class LibrarianManagerImpl implements LibrarianManagerInterface{

    private LibrarianManagerImpl librarianManagerDAO;

    public LibrarianManagerImpl (LibrarianManagerDAO librarianManagerDAO) {this.librarianManagerDAO = librarianManagerDAO}

    public addBookToLibrary addBook(Book book) throws BookAlreadyAddedException
    {
        try{
            librarianManagerDAO.addBook(book);
        }
        catch (BookAlreadyAddedException)
        {
            throw new BookDoesNotExistException(e);
        }
    }

    public updateBook updateBook(Book book) throws BookDoesNotExistException{
        try{
            librarianManagerDAO.updateBook(book);
        }
        catch (BookDoesNotExistException)
        {
            throw new BookDoesNotExistException(e);
        }

    }

    public deleteBook deleteBook(Book book) throws BookDoesNotExistException {
        try {
            librarianManagerDAO.deleteBook(book);
        }
        catch (BookDoesNotExistException)
        {
            throw new BookDoesNotExistException(e);
        }
    }
    @Override
    public Collection<Book> listBooks() {
        return librarianManagerDAO.readBooks();
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


