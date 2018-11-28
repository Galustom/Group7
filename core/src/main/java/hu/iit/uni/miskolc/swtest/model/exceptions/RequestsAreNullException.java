package hu.iit.uni.miskolc.swtest.model.exceptions;

public class RequestsAreNullException extends Exception {
    public RequestsAreNullException() {
    }

    public RequestsAreNullException(String s) {
        super(s);
    }

    public RequestsAreNullException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public RequestsAreNullException(Throwable throwable) {
        super(throwable);
    }

    public RequestsAreNullException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
