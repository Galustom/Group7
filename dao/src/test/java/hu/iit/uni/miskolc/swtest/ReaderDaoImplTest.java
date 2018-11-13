package hu.iit.uni.miskolc.swtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.junit.Assert.*;

public class ReaderDaoImplTest {

    private ReaderDaoImpl readerDao;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        readerDao = new ReaderDaoImpl();
    }

    @Test
    public void listBooks() {
    }

    @Test
    public void listAvailableBooks() {
    }

    @Test
    public void requestBook() {
    }

    @Test
    public void listBorrowings() {
    }

    @After
    public void rollBack() {
        File file = new File("StoredBooks.xml");
        file.delete();
    }
}