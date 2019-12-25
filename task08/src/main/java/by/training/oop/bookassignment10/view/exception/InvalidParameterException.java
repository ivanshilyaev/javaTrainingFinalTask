package by.training.oop.bookassignment10.view.exception;

public class InvalidParameterException extends Exception {
    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(Throwable cause) {
        super(cause);
    }

    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
