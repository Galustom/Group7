package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BookTest {

    Book book;
    Book invalidBook;
    int id = 6461;
    String name = "JANI";
    String genre = "HORROR";
    String author = "PETIKE";
    String publisher = "ZSIGA";
    String isbn = "XDXDXDXD69";
    int quantity = 55;
    int available = 10;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp(){
        book = new Book(this.id,this.name,this.genre,this.author,this.publisher,this.isbn,this.quantity,this.available);
        invalidBook = new Book(this.id,this.name,this.genre,this.author,this.publisher,this.isbn,-1,-1);

    }

    @Test
    public void testConstructorLegalValues() {
        try {
            new Book(this.id,this.name,this.genre,this.author,this.publisher,this.isbn,this.quantity,this.available);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public  void testConstructorIllegalValues() {
        exceptionRule.expect(IllegalArgumentException.class);
        new Book(this.id,null,null,null,null,null,this.quantity,this.available);
        exceptionRule.expect(IllegalArgumentException.class);
        new Book(this.id,"",null,null,null,null,this.quantity,this.available);
        exceptionRule.expect(IllegalArgumentException.class);
        new Book(this.id,null,"",null,null,null,this.quantity,this.available);
        exceptionRule.expect(IllegalArgumentException.class);
        new Book(this.id,null,null,"",null,null,this.quantity,this.available);
        exceptionRule.expect(IllegalArgumentException.class);
        new Book(this.id,null,null,null,"",null,this.quantity,this.available);
        exceptionRule.expect(IllegalArgumentException.class);
        new Book(this.id,null,null,null,null,"",this.quantity,this.available);
    }

    @Test
    public void testGetID() {
        assertEquals(this.id, this.book.getId());
    }

    @Test
    public void testGetName() {
        assertEquals(this.name, this.book.getName());
    }

    @Test
    public void testGetGenre() {
        assertEquals(this.genre, this.book.getGenre());
    }

    @Test
    public void testGetAuthor() {
        assertEquals(this.author, this.book.getAuthor());
    }

    @Test
    public void testGetPublisher() {
        assertEquals(this.publisher, this.book.getPublisher());
    }

    @Test
    public void testGetIsbn() {
        assertEquals(this.isbn, this.book.getIsbn());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(this.quantity, this.book.getQuantity());
    }

    @Test
    public void testGetAvailable() {
        assertEquals(this.available, this.book.getAvailable());
    }

    @Test
    public void testValidateWithGoodValues() {
        assertEquals(true, this.book.validate());
    }

    @Test
    public void testValidateWithBadValues() {
        assertEquals(false, this.invalidBook.validate());
    }
}
