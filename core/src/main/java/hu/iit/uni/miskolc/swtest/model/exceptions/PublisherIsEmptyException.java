package hu.iit.uni.miskolc.swtest.model.exceptions;

public class PublisherIsEmptyException extends Exception {
    public PublisherIsEmptyException() {
    }

    public PublisherIsEmptyException(String s) {
        super(s);
    }

    public PublisherIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PublisherIsEmptyException(Throwable throwable) {
        super(throwable);
    }

    public PublisherIsEmptyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
