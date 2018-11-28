package hu.iit.uni.miskolc.swtest.exceptions;

public class BorrowingsAreNullException extends Exception {
    public BorrowingsAreNullException() {
    }

    public BorrowingsAreNullException(String s) {
        super(s);
    }

    public BorrowingsAreNullException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BorrowingsAreNullException(Throwable throwable) {
        super(throwable);
    }

    public BorrowingsAreNullException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
