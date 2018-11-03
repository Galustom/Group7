package hu.iit.uni.miskolc.swtest.model;

public class Reader extends User {

    private ReaderBorrowing borrowings;

    public Reader(int id, String username, String password, ReaderBorrowing borrowings) {
        super(id, username, password);
        this.borrowings = borrowings;
    }

    public ReaderBorrowing getBorrowings() {
        return borrowings;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "borrowings=" + borrowings +
                '}';
    }
}
