package hu.iit.uni.miskolc.swtest.model;

public class Reader extends User {

    private ReaderBorrowings borrowings;

    public Reader(int id, String username, String password, ReaderBorrowings borrowings) {
        super(id, username, password);
        this.borrowings = borrowings;
    }

    public ReaderBorrowings getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(ReaderBorrowings borrowings) {
        this.borrowings = borrowings;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "borrowings=" + borrowings +
                '}';
    }
}
