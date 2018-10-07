package hu.iit.uni.miskolc.swtest.dao.exceptions;

public class UsernameEntryNotFoundException extends Exception {

    public UsernameEntryNotFoundException() {
        super();
    }

    public UsernameEntryNotFoundException(String message) {
        super(message);
    }

    public UsernameEntryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameEntryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UsernameEntryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
