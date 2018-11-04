package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Library;
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
    public void setUp(){
        booklist = new ArrayList<Book>();
        book = new Book(1,"valami","valami","valami","valami","valami",10,10);
        booklist.add(book);
        library = new Library(this.id,this.name,this.booklist);
    }

    @Test
    public void testConstructorLegalValues() {
        try {
            new Library(this.id,this.name,this.booklist);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public  void testConstructorIllegalValues() {
        exceptionRule.expect(IllegalArgumentException.class);
        new Library(this.id,null,null);
        exceptionRule.expect(IllegalArgumentException.class);
        new Library(this.id,"",null);
    }

    @Test
    public void testGetId() {
        assertEquals(this.id,this.library.getId());
    }

    @Test
    public void testGetName() {
        assertEquals(this.name,this.library.getName());
    }

    @Test
    public void testGetBookList() {
        assertEquals(this.booklist,this.library.getBookList());
    }
}
