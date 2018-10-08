package hu.iit.uni.miskolc.swtest.service.exceptions;

public class BookDoesNotExistException extends Exception {

    public BookDoesNotExistException() {
        super();
    }

    public BookDoesNotExistException(String message) {
        super(message);
    }

    public BookDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDoesNotExistException(Throwable cause) {
        super(cause);
    }

    protected BookDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
