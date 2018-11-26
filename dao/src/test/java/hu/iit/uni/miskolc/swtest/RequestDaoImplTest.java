package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.exceptions.RequestEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.model.Request;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class RequestDaoImplTest {

    private RequestDaoImpl requestDao;
    DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); //String format for conversion

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        requestDao = new RequestDaoImpl();
    }

    @Test
    public void testReadRequests() throws ParseException, RequestEntryAlreadyAddedException {
        Collection<Request> requestinmemory = new ArrayList<>();

        Request request1 = new Request(21, 21, 21, format.parse( "Nov 11, 2018" ), true, 34563456,format.parse( "Nov 11, 2019" ), false, true);
        requestDao.createRequest(request1);
        requestinmemory.add(request1);
        Request request2 = new Request(22, 21, 21, format.parse( "Nov 11, 2018" ), true, 34563456,format.parse( "Nov 11, 2019" ), false, true);
        requestDao.createRequest(request2);
        requestinmemory.add(request2);
        Request request3 = new Request(23, 21, 21, format.parse( "Nov 11, 2018" ), true, 34563456,format.parse( "Nov 11, 2019" ), false, true);
        requestDao.createRequest(request3);
        requestinmemory.add(request3);
        Request request4 = new Request(24, 21, 21, format.parse( "Nov 11, 2018" ), true, 34563456,format.parse( "Nov 11, 2019" ), false, true);
        requestDao.createRequest(request4);
        requestinmemory.add(request4);

        Collection<Request> requests = requestDao.readRequests();
        assertEquals(requestinmemory, requests);
    }

    @Test
    public void testCreateRequest() throws RequestEntryAlreadyAddedException, ParseException {
        Request request = new Request(21, 21, 21, format.parse( "Nov 11, 2018" ), true, 34563456,format.parse( "Nov 11, 2019" ), false, true);
        requestDao.createRequest(request);

        List<Request> requests = (List<Request>) requestDao.readRequests();
        Assert.assertEquals(request.getId(), requests.get(requests.size() - 1).getId());
    }

    @Test
    public void testGetRequest() throws RequestEntryAlreadyAddedException, ParseException {
        Request request = new Request(21, 21, 21, format.parse( "Nov 11, 2018" ), true, 34563456,format.parse( "Nov 11, 2019" ), false, true);
        requestDao.createRequest(request);

        Assert.assertEquals(request, requestDao.GetRequest(request.getId()));
    }

    @After
    public void rollBack() {
        File file = new File("StoredRequests.xml");
        file.delete();
    }
}