package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;

public class ReaderBorrowing {

    private Collection<Book> borrowedBooks;

    public ReaderBorrowing(Collection<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public Collection<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Collection<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "ReaderBorrowing{" +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }
}
