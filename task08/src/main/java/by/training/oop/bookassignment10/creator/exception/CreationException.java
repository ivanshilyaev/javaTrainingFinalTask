package by.training.oop.bookassignment10.creator.exception;

public class CreationException extends Exception {
    public CreationException() {
        super();
    }

    public CreationException(String message) {
        super(message);
    }

    public CreationException(Throwable cause) {
        super(cause);
    }

    public CreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
