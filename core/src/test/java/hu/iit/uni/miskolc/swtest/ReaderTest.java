package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.ReaderBorrowings;
import hu.iit.uni.miskolc.swtest.model.exceptions.BorrowingsAreNullException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ReaderTest {

    private Reader reader;
    private int id = 4556;
    private String username = "alamuszinyuszi";
    private String password = "password";
    private Book book;
    private Collection<Book> booklist;
    private ReaderBorrowings readerBorrowings;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        booklist = new ArrayList<Book>();
        book = new Book(1, "valami", "valami", "valami", "valami", "valami", 10, 10);
        booklist.add(book);
        readerBorrowings = new ReaderBorrowings(booklist);
        reader = new Reader(this.id, this.username, this.password, this.readerBorrowings);
    }

    @Test
    public void testConstructorWithLegalValues() {
        new Reader(this.id, this.username, this.password, this.readerBorrowings);
    }

    @Test
    public void testConstructorWithIllegalValues() {
        new Reader(this.id, null, null, null);
        new Reader(this.id, "", null, null);
        new Reader(this.id, null, "", null);
    }

    @Test
    public void testGetBorrowings() {
        assertEquals(readerBorrowings, this.reader.getBorrowings());
    }

    @Test
    public void testSetBorrowings() throws BorrowingsAreNullException {
        reader.setBorrowings(readerBorrowings);
        assertEquals(readerBorrowings, reader.getBorrowings());
    }

    @Test(expected = BorrowingsAreNullException.class)
    public void testSetNullBorrowings() throws BorrowingsAreNullException {
        booklist = null;
        readerBorrowings.setBorrowedBooks(booklist);
        reader.setBorrowings(readerBorrowings);
    }
}
