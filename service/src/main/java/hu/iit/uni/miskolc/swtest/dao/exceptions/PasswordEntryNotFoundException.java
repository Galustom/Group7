package hu.iit.uni.miskolc.swtest.dao.exceptions;

public class PasswordEntryNotFoundException extends Exception {

    public PasswordEntryNotFoundException() {
        super();
    }

    public PasswordEntryNotFoundException(String message) {
        super(message);
    }

    public PasswordEntryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordEntryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PasswordEntryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
