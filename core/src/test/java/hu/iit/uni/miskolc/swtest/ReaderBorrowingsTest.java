package hu.iit.uni.miskolc.swtest;

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
        borrowedBooks = new ArrayList<Book>();
        book = new Book(1,"valami","valami","valami","valami","valami",10,10);
        borrowedBooks.add(book);
        readerBorrowings = new ReaderBorrowings(borrowedBooks);
    }

    @Test
    public void testConstructorWithLegalValues() {
        try {
            new ReaderBorrowings(borrowedBooks);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorWithIllegalValues() {
        exceptionRule.expect(IllegalArgumentException.class);
        new ReaderBorrowings(null);
    }

    @Test
    public void testGetBorrowedBooks() {
        assertEquals(borrowedBooks,this.readerBorrowings.getBorrowedBooks());
    }

    @Test
    public void testSetBorrowedBooks () {
        borrowedBooks = new ArrayList<Book>();
        book = new Book(1,"valami","valami","valami","valami","valami",10,10);
        borrowedBooks.add(book);
        this.readerBorrowings.setBorrowedBooks(borrowedBooks);
        assertEquals(borrowedBooks, this.readerBorrowings.getBorrowedBooks());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsetBorrowedBooksWithNull () {
        this.readerBorrowings.setBorrowedBooks(null);
    }
}
