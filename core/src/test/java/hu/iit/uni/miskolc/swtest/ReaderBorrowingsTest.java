package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.exceptions.BorrowingsAreNullException;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.ReaderBorrowings;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReaderBorrowingsTest {

    private ReaderBorrowings readerBorrowings;
    private Book book;
    private Collection<Book> borrowedBooks;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        book = new Book(1, "valami", "valami", "valami", "valami", "valami", 10, 10);
        borrowedBooks = new ArrayList<Book>();
        borrowedBooks.add(book);
        readerBorrowings = new ReaderBorrowings(borrowedBooks);
    }

    @Test
    public void testConstructorWithLegalValues() {
        new ReaderBorrowings(borrowedBooks);
    }

    @Test
    public void testConstructorWithIllegalValues() {
        new ReaderBorrowings(null);
    }

    @Test
    public void testGetBorrowedBooks() {
        assertEquals(borrowedBooks, this.readerBorrowings.getBorrowedBooks());
    }

    @Test
    public void testSetBorrowedBooks() throws BorrowingsAreNullException {
        borrowedBooks = new ArrayList<Book>();
        try {
            book = new Book(1, "valami", "valami", "valami", "valami", "valami", 10, 10);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        borrowedBooks.add(book);
        this.readerBorrowings.setBorrowedBooks(borrowedBooks);
        assertEquals(borrowedBooks, this.readerBorrowings.getBorrowedBooks());
    }

    @Test(expected = BorrowingsAreNullException.class)
    public void testSetBorrowedBooksWithNull() throws BorrowingsAreNullException {
        this.readerBorrowings.setBorrowedBooks(null);
    }
}
