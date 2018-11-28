package hu.iit.uni.miskolc.swtest.exceptions;

public class BookListNullException extends Exception {
    public BookListNullException() {
    }

    public BookListNullException(String s) {
        super(s);
    }

    public BookListNullException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BookListNullException(Throwable throwable) {
        super(throwable);
    }

    public BookListNullException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
