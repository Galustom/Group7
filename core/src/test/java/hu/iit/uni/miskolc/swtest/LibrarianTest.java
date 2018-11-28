package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.exceptions.RequestsAreNullException;
import hu.iit.uni.miskolc.swtest.model.Librarian;
import hu.iit.uni.miskolc.swtest.model.Request;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class LibrarianTest {

    private Librarian librarian;
    private int id = 4556;
    private String username = "alamuszinyuszi";
    private String password = "password";
    private Request request;
    private Collection<Request> requests;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        requests = new ArrayList<Request>();
        request = new Request(1, 2, 3, null, false, 3, null, false, false);
        requests.add(request);
        librarian = new Librarian(this.id, this.username, this.password, this.requests);
    }

    @Test
    public void testConstructorLegalValues() {
        new Librarian(this.id, this.username, this.password, this.requests);
    }

    @Test
    public void testConstructorIllegalValues() {
        new Librarian(this.id, null, null, null);
        new Librarian(this.id, "", null, null);
        new Librarian(this.id, null, "", null);
    }

    @Test
    public void testGetRequests() {
        assertEquals(requests, this.librarian.getRequests());
    }

    @Test
    public void testSetRequests() throws RequestsAreNullException {
        librarian.setRequests(requests);
        assertEquals(requests, librarian.getRequests());
    }

    @Test(expected = RequestsAreNullException.class)
    public void testSetNullRequests() throws RequestsAreNullException {
        Collection<Request> requests = null;
        librarian.setRequests(requests);
    }
}
