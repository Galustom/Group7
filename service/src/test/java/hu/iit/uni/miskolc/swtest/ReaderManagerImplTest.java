package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.ReaderDao;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.ReaderBorrowings;
import hu.iit.uni.miskolc.swtest.model.Request;
import hu.iit.uni.miskolc.swtest.service.ReaderManagerImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class ReaderManagerImplTest {

    @Mock
    private ReaderDao readerDaoMock;

    @InjectMocks
    private ReaderManagerImpl readerManager;

    public ReaderManagerImplTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListBooksNoBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        assertEquals(books, readerManager.listBooks());
    }

    @Test
    public void testListBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "valami", "horror", "jani", "kiado", "isbn", 15, 2));

        doReturn(books).when(readerDaoMock).listBooks();

        assertEquals(books, readerManager.listBooks());
    }

    @Test
    public void testListAvailableBooksNoBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        assertEquals(books, readerManager.listAvailableBooks());
    }

    @Test
    public void testListAvailableBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "valami", "horror", "jani", "kiado", "isbn", 15, 2));

        doReturn(books).when(readerDaoMock).listAvailableBooks();

        assertEquals(books, readerManager.listAvailableBooks());
    }

    @Test
    public void testRequestBook() {
        Book book = new Book(1, "valami", "horror", "jani", "kiado", "isbn", 15, 2);
        Calendar calendar = Calendar.getInstance();
        Request request = new Request(1, 1, 1, calendar.getTime(), false, 1, calendar.getTime(), false, true);
        ArrayList<Book> books = new ArrayList<Book>();
        ReaderBorrowings readerBorrowings = new ReaderBorrowings(books);
        Reader reader = new Reader(1, "valami", "valamipass", readerBorrowings);
        readerManager.requestBook(request, book, reader);
    }

    @Test
    public void testListBorrowingsNoBorrowing() {
        ArrayList<Book> books = new ArrayList<Book>();
        ReaderBorrowings readerBorrowings = new ReaderBorrowings(books);
        Reader reader = new Reader(1, "valami", "valami", readerBorrowings);

        doReturn(books).when(readerDaoMock).listBorrowings(reader);
        assertEquals(books, readerManager.listBorrowings(reader));
    }

    @Test
    public void testListBorrowings() {
        ArrayList<Book> books = new ArrayList<Book>();
        ReaderBorrowings readerBorrowings = new ReaderBorrowings(books);
        books.add(new Book(1, "valami", "horror", "jani", "kiado", "isbn", 15, 2));
        Reader reader = new Reader(1, "valami", "valami", readerBorrowings);

        doReturn(books).when(readerDaoMock).listBorrowings(reader);
        assertEquals(books, readerManager.listBorrowings(reader));
    }
}
