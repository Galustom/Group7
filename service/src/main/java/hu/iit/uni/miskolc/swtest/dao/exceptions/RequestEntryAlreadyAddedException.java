package hu.iit.uni.miskolc.swtest.dao.exceptions;

public class RequestEntryAlreadyAddedException extends Exception {
    public RequestEntryAlreadyAddedException() {
        super();
    }

    public RequestEntryAlreadyAddedException(String message) {
        super(message);
    }

    public RequestEntryAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestEntryAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    protected RequestEntryAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

