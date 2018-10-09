package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;

public class Reader extends User {

    private Collection<Book> borrowings;

    public Reader(int id, String username, String password, Collection<Book> borrowings) {
        super(id, username, password);
        this.borrowings = borrowings;
    }

    public Collection<Book> getBorrowings() {
        return borrowings;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "borrowings=" + borrowings +
                '}';
    }
}
