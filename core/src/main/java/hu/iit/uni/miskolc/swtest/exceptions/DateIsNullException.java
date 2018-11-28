package hu.iit.uni.miskolc.swtest.exceptions;

public class DateIsNullException extends Exception {
    public DateIsNullException() {
    }

    public DateIsNullException(String s) {
        super(s);
    }

    public DateIsNullException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DateIsNullException(Throwable throwable) {
        super(throwable);
    }

    public DateIsNullException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
