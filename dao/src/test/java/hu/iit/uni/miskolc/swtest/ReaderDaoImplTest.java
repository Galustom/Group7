package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class ReaderDaoImplTest {

    private ReaderDaoImpl readerDao;
    private BookDaoImpl bookDao;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        readerDao = new ReaderDaoImpl();
        bookDao = new BookDaoImpl();
    }

    @Test
    public void listBooks() throws BookEntryAlreadyAddedException {
        Collection<Book> bookinmemory = new ArrayList<>();

        Book book1 = new Book(6461, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 10);
        bookDao.createBook(book1);
        bookinmemory.add(book1);
        Book book2 = new Book(6462, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 10);
        bookDao.createBook(book2);
        bookinmemory.add(book2);
        Book book3 = new Book(6463, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 10);
        bookDao.createBook(book3);
        bookinmemory.add(book3);
        Book book4 = new Book(6464, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 10);
        bookDao.createBook(book4);
        bookinmemory.add(book4);

        Collection<Book> books = readerDao.listBooks();
        assertEquals(bookinmemory, books);
    }

    @Test
    public void listAvailableBooks() throws BookEntryAlreadyAddedException {
        Collection<Book> bookinmemory = new ArrayList<>();

        Book book1 = new Book(6461, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 0);
        bookDao.createBook(book1);
        Book book2 = new Book(6462, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 10);
        bookDao.createBook(book2);
        bookinmemory.add(book2);
        Book book3 = new Book(6463, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 0);
        bookDao.createBook(book3);
        Book book4 = new Book(6464, "PETI", "HORROR", "ZSOLTIKA", "ZSIGA", "ASDFGHJK10", 55, 10);
        bookDao.createBook(book4);
        bookinmemory.add(book4);

        Collection<Book> books = readerDao.listAvailableBooks();
        assertEquals(bookinmemory, books);
    }

    @Test
    public void requestBook() {
    }

    @Test
    public void listBorrowings() {
    }

    @After
    public void rollBack() {
        File file = new File("StoredBooks.xml");
        file.delete();
    }
}