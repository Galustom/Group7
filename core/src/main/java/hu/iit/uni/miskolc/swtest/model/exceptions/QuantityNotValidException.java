package hu.iit.uni.miskolc.swtest.model.exceptions;

public class QuantityNotValidException extends Exception {
    public QuantityNotValidException() {
    }

    public QuantityNotValidException(String s) {
        super(s);
    }

    public QuantityNotValidException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public QuantityNotValidException(Throwable throwable) {
        super(throwable);
    }

    public QuantityNotValidException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
