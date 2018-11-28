package hu.iit.uni.miskolc.swtest.model;


import hu.iit.uni.miskolc.swtest.exceptions.DateIsNullException;
import hu.iit.uni.miskolc.swtest.exceptions.IdNotValidException;

import java.util.Calendar;
import java.util.Date;

public class Request {

    private int id;

    private int bookId;

    private int readerId;

    private Date requestDate;

    private boolean approve;

    private int approvalLibrarianId;

    private Date deadline;

    private boolean returned;

    private boolean active;

    public Request(int id, int bookId, int readerId, Date requestDate, boolean approve, int approvalLibrarianId, Date deadline, boolean returned, boolean active) {
        this.id = id; //It need to be auto generated after items in Database/XML
        this.bookId = bookId;
        this.readerId = readerId;
        this.requestDate = requestDate;
        this.approve = approve;
        this.approvalLibrarianId = approvalLibrarianId;
        this.deadline = deadline;
        this.returned = returned;
        this.active = active;
    }

    public Request(int requestId, int bookId, int readerId) {
        this.id = requestId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.requestDate = new Date();
        this.approve = false;
        this.approvalLibrarianId = 0;
        int noOfDays = 14; //Two Week
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.requestDate);
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        this.deadline = calendar.getTime();
        this.returned = false;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws IdNotValidException {
        if (id <= 0)
            throw new IdNotValidException();
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) throws IdNotValidException {
        if (bookId <= 0)
            throw new IdNotValidException();
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) throws IdNotValidException {
        if (readerId <= 0)
            throw new IdNotValidException();
        this.readerId = readerId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) throws DateIsNullException {
        if (requestDate == null)
            throw new DateIsNullException();
        this.requestDate = requestDate;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public int getApprovalLibrarianId() {
        return approvalLibrarianId;
    }

    public void setApprovalLibrarianId(int approvalLibrarianId) throws IdNotValidException {
        if (approvalLibrarianId <= 0)
            throw new IdNotValidException();
        this.approvalLibrarianId = approvalLibrarianId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) throws DateIsNullException {
        if (deadline == null)
            throw new DateIsNullException();
        this.deadline = deadline;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", requestDate=" + requestDate +
                ", approve=" + approve +
                ", approvalLibrarianId=" + approvalLibrarianId +
                ", deadline=" + deadline +
                ", returned=" + returned +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id &&
                bookId == request.bookId &&
                readerId == request.readerId &&
                requestDate.equals(request.requestDate) &&
                approve == request.approve &&
                approvalLibrarianId == request.approvalLibrarianId &&
                deadline.equals(request.deadline) &&
                returned == request.returned &&
                active == request.active;
    }

    /*private Collection<Book> requestedBooks;

    public Request(Collection<Book> requestedBooks) {
        this.requestedBooks = requestedBooks;
    }

    public Collection<Book> getRequestedBooks() {
        return requestedBooks;
    }*/
}
