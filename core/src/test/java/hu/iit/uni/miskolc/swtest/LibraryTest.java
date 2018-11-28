package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Library;
import hu.iit.uni.miskolc.swtest.model.exceptions.BookListNullException;
import hu.iit.uni.miskolc.swtest.model.exceptions.IdNotValidException;
import hu.iit.uni.miskolc.swtest.model.exceptions.NameIsEmptyException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LibraryTest {

    private Library library;
    private int id = 4556;
    private String name = "libsilibrary";
    private Book book;
    private Collection<Book> booklist;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        booklist = new ArrayList<Book>();
        book = new Book(1, "valami", "valami", "valami", "valami", "valami", 10, 10);
        booklist.add(book);
        library = new Library(this.id, this.name, this.booklist);
    }

    @Test
    public void testConstructorLegalValues() {
        try {
            new Library(this.id, this.name, this.booklist);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorIllegalValues() {
        try {
            new Library(this.id, null, null);
            new Library(this.id, "", null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetId() {
        assertEquals(this.id, this.library.getId());
    }

    @Test
    public void testGetName() {
        assertEquals(this.name, this.library.getName());
    }

    @Test
    public void testGetBookList() {
        assertEquals(this.booklist, this.library.getBookList());
    }

    @Test
    public void testSetID() throws IdNotValidException {
        library.setId(1);
        assertEquals(1, library.getId());
    }

    @Test(expected = IdNotValidException.class)
    public void testSetInvalidID() throws IdNotValidException {
        library.setId(-1);
    }

    @Test
    public void testSetName() throws NameIsEmptyException {
        library.setName("testName");
        assertEquals("testName", library.getName());
    }

    @Test(expected = NameIsEmptyException.class)
    public void testSetEmptyName() throws NameIsEmptyException {
        library.setName("");
    }

    @Test
    public void testSetBookList() throws BookListNullException {
        booklist.add(book);
        library.setBookList(booklist);
        assertEquals(booklist, library.getBookList());
    }

    @Test(expected = BookListNullException.class)
    public void testSetNullBookList() throws BookListNullException {
        Collection<Book> bookList = null;
        library.setBookList(bookList);
    }
}
