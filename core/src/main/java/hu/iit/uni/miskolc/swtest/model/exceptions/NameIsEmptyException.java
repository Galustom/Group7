package hu.iit.uni.miskolc.swtest.model.exceptions;

public class NameIsEmptyException extends Exception {
    public NameIsEmptyException() {
    }

    public NameIsEmptyException(String s) {
        super(s);
    }

    public NameIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NameIsEmptyException(Throwable throwable) {
        super(throwable);
    }

    public NameIsEmptyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
