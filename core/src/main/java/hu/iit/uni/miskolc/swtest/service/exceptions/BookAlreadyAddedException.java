package hu.iit.uni.miskolc.swtest.service.exceptions;

public class BookAlreadyAddedException extends Exception {

    public BookAlreadyAddedException() {
        super();
    }

    public BookAlreadyAddedException(String message) {
        super(message);
    }

    public BookAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    protected BookAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
