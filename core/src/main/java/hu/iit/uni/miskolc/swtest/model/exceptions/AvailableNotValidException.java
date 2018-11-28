package hu.iit.uni.miskolc.swtest.model.exceptions;

public class AvailableNotValidException extends Exception {
    public AvailableNotValidException() {
    }

    public AvailableNotValidException(String s) {
        super(s);
    }

    public AvailableNotValidException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AvailableNotValidException(Throwable throwable) {
        super(throwable);
    }

    public AvailableNotValidException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
