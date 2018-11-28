package hu.iit.uni.miskolc.swtest.exceptions;

public class AuthorIsEmptyException extends Exception {
    public AuthorIsEmptyException() {
    }

    public AuthorIsEmptyException(String s) {
        super(s);
    }

    public AuthorIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AuthorIsEmptyException(Throwable throwable) {
        super(throwable);
    }

    public AuthorIsEmptyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
