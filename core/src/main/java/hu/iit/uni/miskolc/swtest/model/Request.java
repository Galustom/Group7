package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;

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
}
