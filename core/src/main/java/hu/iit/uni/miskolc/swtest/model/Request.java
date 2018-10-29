package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;
import java.util.Date;

public class Request {

    private Collection<Book> requestedBooks;

    public Request(Collection<Book> requestedBooks) {
        this.requestedBooks = requestedBooks;
    }

    public Collection<Book> getRequestedBooks() {
        return requestedBooks;
    }

    public void setRequestedBooks(Collection<Book> requestedBooks) {
        this.requestedBooks = requestedBooks;
    }

    @Override
    public String toString() {
        return "Request{" +
                ", requestedBooks=" + requestedBooks +
                '}';
    }
    private int id;

    private int bookId;

    private int readerId;

    private Date requestDate;

    private boolean approve;

    private int approvalLibrarianId;

    private Date deadline;

    private boolean returned;
    
    private boolean active;

    /*public void setRequest(Book book, Reader reader){};

    public void approve (int requestId, Date date){
        Request requestBook = getRequest(readerId); //Need to implement getRequest()
        requestBook.approve = true;
        requestBook.approvalLibrarian = getCurrentLibrarian(); //Need to implement getCurrentLibrarian()
    }*/
}
