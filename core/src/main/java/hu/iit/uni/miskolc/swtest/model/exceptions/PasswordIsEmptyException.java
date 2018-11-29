package hu.iit.uni.miskolc.swtest.model.exceptions;

public class PasswordIsEmptyException extends Exception {
    public PasswordIsEmptyException() {
    }

    public PasswordIsEmptyException(String s) {
        super(s);
    }

    public PasswordIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PasswordIsEmptyException(Throwable throwable) {
        super(throwable);
    }

    public PasswordIsEmptyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
