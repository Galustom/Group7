package hu.iit.uni.miskolc.swtest.dao.exceptions;

public class BookEntryNotFoundException extends Exception {

    public BookEntryNotFoundException() {
        super();
    }

    public BookEntryNotFoundException(String message) {
        super(message);
    }

    public BookEntryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookEntryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BookEntryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
