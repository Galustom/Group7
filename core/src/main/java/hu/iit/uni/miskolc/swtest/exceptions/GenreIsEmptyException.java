package hu.iit.uni.miskolc.swtest.exceptions;

public class GenreIsEmptyException extends Exception {
    public GenreIsEmptyException() {
    }

    public GenreIsEmptyException(String s) {
        super(s);
    }

    public GenreIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GenreIsEmptyException(Throwable throwable) {
        super(throwable);
    }

    public GenreIsEmptyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
