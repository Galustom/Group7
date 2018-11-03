package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Librarian;
import hu.iit.uni.miskolc.swtest.model.Request;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LibrarianTest {

    Librarian librarian;
    int id = 4556;
    String username = "alamuszinyuszi";
    String password = "password";
    Request request;
    Collection<Request> requests;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp(){
        requests = new ArrayList<Request>();
        request = new Request(1,2,3,null,false,3,null,false,false);
        requests.add(request);
        librarian = new Librarian(this.id,this.username,this.password,this.requests);
    }

    @Test
    public void testConstructorLegalValues() {
        try {
            new Librarian(this.id,this.username,this.password,this.requests);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public  void testConstructorIllegalValues() {
        exceptionRule.expect(IllegalArgumentException.class);
        new Librarian(this.id,null,null,null);
        exceptionRule.expect(IllegalArgumentException.class);
        new Librarian(this.id,"",null,null);
        exceptionRule.expect(IllegalArgumentException.class);
        new Librarian(this.id,null,"",null);
    }

    @Test
    public void testGetRequests() {
        assertEquals(requests,this.librarian.getRequests());
    }
}
