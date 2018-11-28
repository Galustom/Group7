package hu.iit.uni.miskolc.swtest.exceptions;

public class IdNotValidException extends Exception {
    public IdNotValidException() {
    }

    public IdNotValidException(String s) {
        super(s);
    }

    public IdNotValidException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IdNotValidException(Throwable throwable) {
        super(throwable);
    }

    public IdNotValidException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
