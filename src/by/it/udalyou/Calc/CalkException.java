package by.it.udalyou.Calc;

public class CalkException extends Exception {
    public CalkException() {
    }

    public CalkException(String message) {
        super("ERROR: "+message);
    }

    public CalkException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalkException(Throwable cause) {
        super(cause);
    }

    public CalkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+message, cause, enableSuppression, writableStackTrace);
    }
}
