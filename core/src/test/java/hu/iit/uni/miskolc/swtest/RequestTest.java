package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.Request;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
        request = new Request(this.id,this.bookId,this.readerId,this.requestDate.getTime(),this.approve,this.approvalLibrarianId,this.deadline.getTime(),this.returned,this.active);
    }

    @Test
    public void testConstructorWithLegalValues() {
        try {
            new Request(this.id,this.bookId,this.readerId,this.requestDate.getTime(),this.approve,this.approvalLibrarianId,this.deadline.getTime(),this.returned,this.active);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorWithIllegalValues() {
        exceptionRule.expect(IllegalArgumentException.class);
        request = new Request(this.id,this.bookId,this.readerId,null,this.approve,this.approvalLibrarianId,null,this.returned,this.active);
        exceptionRule.expect(IllegalArgumentException.class);
        request = new Request(this.id,this.bookId,this.readerId,null,this.approve,this.approvalLibrarianId,this.deadline.getTime(),this.returned,this.active);
        exceptionRule.expect(IllegalArgumentException.class);
        request = new Request(this.id,this.bookId,this.readerId,this.requestDate.getTime(),this.approve,this.approvalLibrarianId,null,this.returned,this.active);
    }

    @Test
    public void testGetId() {
        assertEquals(id,this.request.getId());
    }

    @Test
    public void testSetId() {
        int id = 12313;
        this.request.setId(id);
        assertEquals(id,this.request.getId());
    }

    @Test
    public void testGetBookId() {
        assertEquals(bookId, this.request.getBookId());
    }

    @Test
    public void testSetBookId() {
        int bookID = 6151;
        this.request.setBookId(bookID);
        assertEquals(bookID, this.request.getBookId());
    }

    @Test
    public void testGetReaderId() {
        assertEquals(readerId,this.request.getReaderId());
    }

    @Test
    public void testSetReaderId() {
        int readerId = 53;
        this.request.setReaderId(readerId);
        assertEquals(readerId,this.request.getReaderId());
    }

    @Test
    public void testGetRequestDate() {
        assertEquals(requestDate,this.request.getRequestDate());
    }

    @Test
    public void testSetRequestDate() {
        Calendar RequestDate = Calendar.getInstance();
        RequestDate.set(2011, Calendar.DECEMBER, 14);
        this.request.setRequestDate(requestDate.getTime());
        assertEquals(RequestDate,this.request.getRequestDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetRequestDateWithNull() {
        this.request.setRequestDate(null);
    }

    @Test
    public void testIsApprove() {
        assertEquals(approve,this.request.isApprove());
    }

    @Test
    public void testSetApprove() {
        boolean approve = true;
        this.request.setApprove(approve);
        assertEquals(approve,this.request.isApprove());
    }

    @Test
    public void testGetApprovalLibrarianId() {
        assertEquals(approvalLibrarianId,this.request.getApprovalLibrarianId());
    }

    @Test
    public void testSetApprovalLibrarianId() {
        int approvalLibID = 6151;
        this.request.setApprovalLibrarianId(approvalLibID);
        assertEquals(approvalLibID, this.request.getApprovalLibrarianId());
    }

    @Test
    public void testGetDeadline() {
        assertEquals(deadline,this.request.getDeadline());
    }

    @Test
    public void testSetDeadline() {
        Calendar deadline = Calendar.getInstance();
        deadline.set(2011, Calendar.DECEMBER, 14);
        this.request.setRequestDate(requestDate.getTime());
        assertEquals(deadline,this.request.getDeadline());
    }

    @Test
    public void testIsReturned() {
        assertEquals(returned,this.request.isReturned());
    }

    @Test
    public void testSetReturned() {
        boolean returned = true;
        this.request.setReturned(returned);
        assertEquals(returned,this.request.isReturned());
    }

    @Test
    public void testIsActive() {
        assertEquals(active,this.request.isActive());
    }

    @Test
    public void testSetActive() {
        boolean active = true;
        this.request.setActive(active);
        assertEquals(active,this.request.isActive());
    }
}
