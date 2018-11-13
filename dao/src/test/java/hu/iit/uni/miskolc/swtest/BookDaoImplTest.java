package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.model.Book;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookDaoImplTest {

    private BookDaoImpl bookDao;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bookDao = new BookDaoImpl();
    }

    @Test
    public void testCreateBook() throws BookEntryAlreadyAddedException {
        Book book = new Book(6461, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book);

        List<Book> books = (List<Book>) bookDao.readBooks();
        Assert.assertEquals(book.getId(), books.get(books.size() - 1).getId());
    }

    @Test
    public void testReadBooks() throws BookEntryAlreadyAddedException {
        //TODO: It can't compare the arrays, in spite they contain the same data, "Assert.assertEquals" returns false...
        Collection<Book> bookinmemory = new ArrayList<>();

        Book book1 = new Book(6461, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book1);
        bookinmemory.add(book1);
        Book book2 = new Book(6462, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book2);
        bookinmemory.add(book2);
        Book book3 = new Book(6463, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book3);
        bookinmemory.add(book3);
        Book book4 = new Book(6464, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book4);
        bookinmemory.add(book4);

        Collection<Book> books = bookDao.readBooks();
        assertEquals(bookinmemory, books);
    }

    @Test
    public void testUpdateBook() {
    }

    @Test
    public void testDeleteBook() {
    }

    @Test
    public void testReadAllBook() {
    }

    @After
    public void rollBack() {
        File file = new File("StoredBooks.xml");
        file.delete();
    }
}