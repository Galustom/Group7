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

    Reader reader;
    int id = 4556;
    String username = "alamuszinyuszi";
    String password = "password";
    Book book;
    Collection<Book> booklist;
    ReaderBorrowings readerBorrowings;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        booklist = new ArrayList<Book>();
        book = new Book(1,"valami","valami","valami","valami","valami",10,10);
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
        exceptionRule.expect(IllegalArgumentException.class);
        new Reader(this.id,null,null,null);
        exceptionRule.expect(IllegalArgumentException.class);
        new Reader(this.id,"",null,null);
        exceptionRule.expect(IllegalArgumentException.class);
        new Reader(this.id,null,"",null);
    }

    @Test
    public void testGetBorrowings() {
        assertEquals(readerBorrowings,this.reader.getBorrowings());
    }
}
