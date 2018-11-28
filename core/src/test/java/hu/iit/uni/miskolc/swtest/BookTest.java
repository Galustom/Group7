package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.exceptions.*;
import hu.iit.uni.miskolc.swtest.model.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BookTest {

    private Book book;
    private int id = 6461;
    private String name = "JANI";
    private String genre = "HORROR";
    private String author = "PETIKE";
    private String publisher = "ZSIGA";
    private String isbn = "XDXDXDXD69";
    private int quantity = 55;
    private int available = 10;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        try {
            book = new Book(this.id, this.name, this.genre, this.author, this.publisher, this.isbn, this.quantity, this.available);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorLegalValues() {
        try {
            new Book(this.id, this.name, this.genre, this.author, this.publisher, this.isbn, this.quantity, this.available);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorIllegalValues() throws IsbnIsEmptyException, AuthorIsEmptyException, NameIsEmptyException, AvailableNotValidException, IdNotValidException, QuantityNotValidException, GenreIsEmptyException, PublisherIsEmptyException {
        new Book(this.id, null, null, null, null, null, this.quantity, this.available);
        new Book(this.id, "", null, null, null, null, this.quantity, this.available);
        new Book(this.id, null, "", null, null, null, this.quantity, this.available);
        new Book(this.id, null, null, "", null, null, this.quantity, this.available);
        new Book(this.id, null, null, null, "", null, this.quantity, this.available);
        new Book(this.id, null, null, null, null, "", this.quantity, this.available);
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
    public void testSetID() throws IdNotValidException {
        book.setId(1);
        assertEquals(1, book.getId());
    }

    @Test(expected = IdNotValidException.class)
    public void testSetInvalidID() throws IdNotValidException {
        book.setId(-1);
    }

    @Test
    public void testSetName() throws NameIsEmptyException {
        book.setName("testName");
        assertEquals("testName", book.getName());
    }

    @Test(expected = NameIsEmptyException.class)
    public void testSetEmptyName() throws NameIsEmptyException {
        book.setName("");
    }

    @Test
    public void testSetGenre() throws GenreIsEmptyException {
        book.setGenre("valami");
        assertEquals("valami", book.getGenre());
    }

    @Test(expected = GenreIsEmptyException.class)
    public void testSetEmptyGenre() throws GenreIsEmptyException {
        book.setGenre("");
    }

    @Test
    public void testSetAuthor() throws AuthorIsEmptyException {
        book.setAuthor("valami");
        assertEquals("valami", book.getAuthor());
    }

    @Test(expected = AuthorIsEmptyException.class)
    public void testSetEmptyAuthor() throws AuthorIsEmptyException {
        book.setAuthor("");
    }

    @Test
    public void testSetPublisher() throws PublisherIsEmptyException {
        book.setPublisher("valami");
        assertEquals("valami", book.getPublisher());
    }

    @Test(expected = PublisherIsEmptyException.class)
    public void testSetEmptyPublisher() throws PublisherIsEmptyException {
        book.setPublisher("");
    }

    @Test
    public void testSetIsbn() throws IsbnIsEmptyException {
        book.setIsbn("valami");
        assertEquals("valami", book.getIsbn());
    }

    @Test(expected = IsbnIsEmptyException.class)
    public void testSetEmptyIsbn() throws IsbnIsEmptyException {
        book.setIsbn("");
    }

    @Test
    public void testSetQuantity() throws QuantityNotValidException {
        book.setQuantity(1);
        assertEquals(1, book.getQuantity());
    }

    @Test(expected = QuantityNotValidException.class)
    public void testSetInvalidQuantity() throws QuantityNotValidException {
        book.setQuantity(-1);
    }

    @Test
    public void testSetAvailable() throws AvailableNotValidException {
        book.setAvailable(1);
        assertEquals(1, book.getAvailable());
    }

    @Test(expected = AvailableNotValidException.class)
    public void testSetInvalidAvailable() throws AvailableNotValidException {
        book.setAvailable(-1);
    }
}
