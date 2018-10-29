package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> Dao-and-file-handling-#7
=======
>>>>>>> origin/Implementation-of-LibrarianManagerInterface-#12

public class Request {

    private Collection<Book> requestedBooks;

    public Request(Collection<Book> requestedBooks) {
        this.requestedBooks = requestedBooks;
    }

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> Dao-and-file-handling-#7
=======

>>>>>>> origin/Implementation-of-LibrarianManagerInterface-#12
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
<<<<<<< HEAD
<<<<<<< HEAD
=======

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
>>>>>>> Dao-and-file-handling-#7
=======
>>>>>>> origin/Implementation-of-LibrarianManagerInterface-#12
}
