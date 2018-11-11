package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookDaoImplTest {

    //TODO: Make rollback function to every test-case

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

        Book book = new Book(6461, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book);
        bookinmemory.add(book);
        book = new Book(6462, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book);
        bookinmemory.add(book);
        book = new Book(6463, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book);
        bookinmemory.add(book);
        book = new Book(6464, "JANI", "HORROR", "PETIKE", "ZSIGA", "XDXDXDXD69", 55, 10);
        bookDao.createBook(book);
        bookinmemory.add(book);

        List<Book> books = (List<Book>) bookDao.readBooks();
        Assert.assertEquals(bookinmemory, books);
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
}