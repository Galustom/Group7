package hu.iit.uni.miskolc.swtest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RequestDaoImplTest {

    private RequestDaoImpl requestDao;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        requestDao = new RequestDaoImpl();
    }

    @Test
    public void testReadRequests() {
    }

    @Test
    public void testCreateRequest() {
    }

    @Test
    public void testReadAllRequest() {
    }

    @Test
    public void testGetRequest() {
    }
}