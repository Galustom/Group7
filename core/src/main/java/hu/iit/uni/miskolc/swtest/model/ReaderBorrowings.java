package hu.iit.uni.miskolc.swtest.model;

import hu.iit.uni.miskolc.swtest.model.exceptions.BorrowingsAreNullException;

import java.util.Collection;

public class ReaderBorrowings {

    private Collection<Book> borrowedBooks;

    public ReaderBorrowings(Collection<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public Collection<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Collection<Book> borrowedBooks) throws BorrowingsAreNullException {
        if (borrowedBooks == null)
            throw new BorrowingsAreNullException();
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "ReaderBorrowings{" +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }
}
