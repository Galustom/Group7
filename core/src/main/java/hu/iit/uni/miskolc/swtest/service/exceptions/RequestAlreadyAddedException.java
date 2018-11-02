package hu.iit.uni.miskolc.swtest.service.exceptions;

public class RequestAlreadyAddedException extends Exception {
    public RequestAlreadyAddedException() {
        super();
    }

    public RequestAlreadyAddedException(String message) {
        super(message);
    }

    public RequestAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    protected RequestAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
