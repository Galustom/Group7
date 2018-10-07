package hu.iit.uni.miskolc.swtest.dao.exceptions;

public class BookEntryAlreadyAddedException extends Exception {

    public BookEntryAlreadyAddedException() {
        super();
    }

    public BookEntryAlreadyAddedException(String message) {
        super(message);
    }

    public BookEntryAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookEntryAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    protected BookEntryAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
