package hu.iit.uni.miskolc.swtest.exceptions;

public class UsernameIsEmptyException extends Exception {
    public UsernameIsEmptyException() {
    }

    public UsernameIsEmptyException(String s) {
        super(s);
    }

    public UsernameIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UsernameIsEmptyException(Throwable throwable) {
        super(throwable);
    }

    public UsernameIsEmptyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
