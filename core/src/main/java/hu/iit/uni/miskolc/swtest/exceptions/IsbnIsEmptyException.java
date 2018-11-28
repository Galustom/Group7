package hu.iit.uni.miskolc.swtest.exceptions;

public class IsbnIsEmptyException extends Exception {
    public IsbnIsEmptyException() {
    }

    public IsbnIsEmptyException(String s) {
        super(s);
    }

    public IsbnIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IsbnIsEmptyException(Throwable throwable) {
        super(throwable);
    }

    public IsbnIsEmptyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
