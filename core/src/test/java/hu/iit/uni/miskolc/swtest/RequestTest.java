package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Request;
import hu.iit.uni.miskolc.swtest.model.exceptions.DateIsNullException;
import hu.iit.uni.miskolc.swtest.model.exceptions.IdNotValidException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class RequestTest {

    private Request request;
    private int id = 166;
    private int bookId = 65;
    private int readerId = 345;
    private Calendar requestDate = Calendar.getInstance();
    private boolean approve = false;
    private int approvalLibrarianId = 661;
    private Calendar deadline = Calendar.getInstance();
    private boolean returned = false;
    private boolean active = true;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        requestDate.set(2010, Calendar.DECEMBER, 15);
        deadline.set(2010, Calendar.JANUARY, 23);
        request = new Request(this.id, this.bookId, this.readerId, this.requestDate.getTime(), this.approve, this.approvalLibrarianId, this.deadline.getTime(), this.returned, this.active);
    }

    @Test
    public void testConstructorWithLegalValues() {
        new Request(this.id, this.bookId, this.readerId, this.requestDate.getTime(), this.approve, this.approvalLibrarianId, this.deadline.getTime(), this.returned, this.active);
    }

    @Test
    public void testConstructorWithIllegalValues() {
        request = new Request(this.id, this.bookId, this.readerId, null, this.approve, this.approvalLibrarianId, null, this.returned, this.active);
        request = new Request(this.id, this.bookId, this.readerId, null, this.approve, this.approvalLibrarianId, this.deadline.getTime(), this.returned, this.active);
        request = new Request(this.id, this.bookId, this.readerId, this.requestDate.getTime(), this.approve, this.approvalLibrarianId, null, this.returned, this.active);
    }

    @Test
    public void testGetId() {
        assertEquals(id, this.request.getId());
    }

    @Test
    public void testSetId() throws IdNotValidException {
        int id = 12313;
        this.request.setId(id);
        assertEquals(id, this.request.getId());
    }

    @Test(expected = IdNotValidException.class)
    public void testSetInvalidID() throws IdNotValidException {
        request.setId(-1);
    }

    @Test
    public void testGetBookId() {
        assertEquals(bookId, this.request.getBookId());
    }

    @Test
    public void testSetBookId() throws IdNotValidException {
        int bookID = 6151;
        this.request.setBookId(bookID);
        assertEquals(bookID, this.request.getBookId());
    }

    @Test(expected = IdNotValidException.class)
    public void testSetInvalidBookID() throws IdNotValidException {
        request.setBookId(-1);
    }

    @Test
    public void testGetReaderId() {
        assertEquals(readerId, this.request.getReaderId());
    }

    @Test
    public void testSetReaderId() throws IdNotValidException {
        int readerId = 53;
        this.request.setReaderId(readerId);
        assertEquals(readerId, this.request.getReaderId());
    }

    @Test(expected = IdNotValidException.class)
    public void testSetInvalidReaderID() throws IdNotValidException {
        request.setReaderId(-1);
    }

    @Test
    public void testGetRequestDate() {
        assertEquals(requestDate.getTime(), this.request.getRequestDate());
    }

    @Test
    public void testSetRequestDate() throws DateIsNullException {
        Calendar RequestDate = Calendar.getInstance();
        RequestDate.set(2011, Calendar.DECEMBER, 14);
        this.request.setRequestDate(RequestDate.getTime());
        assertEquals(RequestDate.getTime(), this.request.getRequestDate());
    }

    @Test(expected = DateIsNullException.class)
    public void testSetRequestDateWithNull() throws DateIsNullException {
        this.request.setRequestDate(null);
    }

    @Test
    public void testIsApprove() {
        assertEquals(approve, this.request.isApprove());
    }

    @Test
    public void testSetApprove() {
        boolean approve = true;
        this.request.setApprove(approve);
        assertEquals(approve, this.request.isApprove());
    }

    @Test
    public void testGetApprovalLibrarianId() {
        assertEquals(approvalLibrarianId, this.request.getApprovalLibrarianId());
    }

    @Test
    public void testSetApprovalLibrarianId() throws IdNotValidException {
        int approvalLibID = 6151;
        this.request.setApprovalLibrarianId(approvalLibID);
        assertEquals(approvalLibID, this.request.getApprovalLibrarianId());
    }

    @Test(expected = IdNotValidException.class)
    public void testSetInvalidAppLibID() throws IdNotValidException {
        request.setApprovalLibrarianId(-1);
    }

    @Test
    public void testGetDeadline() {
        assertEquals(deadline.getTime(), this.request.getDeadline());
    }

    @Test
    public void testSetDeadline() throws DateIsNullException {
        Calendar deadline = Calendar.getInstance();
        deadline.set(2011, Calendar.DECEMBER, 14);
        this.request.setDeadline(deadline.getTime());
        assertEquals(deadline.getTime(), this.request.getDeadline());
    }

    @Test(expected = DateIsNullException.class)
    public void testSetDeadlineWithNull() throws DateIsNullException {
        this.request.setDeadline(null);
    }

    @Test
    public void testIsReturned() {
        assertEquals(returned, this.request.isReturned());
    }

    @Test
    public void testSetReturned() {
        boolean returned = true;
        this.request.setReturned(returned);
        assertEquals(returned, this.request.isReturned());
    }

    @Test
    public void testIsActive() {
        assertEquals(active, this.request.isActive());
    }

    @Test
    public void testSetActive() {
        boolean active = true;
        this.request.setActive(active);
        assertEquals(active, this.request.isActive());
    }
}
