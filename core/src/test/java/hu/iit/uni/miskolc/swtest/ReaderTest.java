package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.ReaderBorrowings;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
        try {
        book = new Book(1,"valami","valami","valami","valami","valami",10,10);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        booklist.add(book);
        readerBorrowings = new ReaderBorrowings(booklist);
        reader = new Reader(this.id,this.username,this.password,this.readerBorrowings);
    }

    @Test
    public void testConstructorWithLegalValues() {
        try {
            new Reader(this.id,this.username,this.password,this.readerBorrowings);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorWithIllegalValues() {
        try {
            new Reader(this.id,null,null,null);
            new Reader(this.id,"",null,null);
            new Reader(this.id,null,"",null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetBorrowings() {
        assertEquals(readerBorrowings,this.reader.getBorrowings());
    }
}
