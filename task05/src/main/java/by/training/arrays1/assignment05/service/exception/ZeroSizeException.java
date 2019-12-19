package by.training.arrays1.assignment05.service.exception;

public class ZeroSizeException extends Exception {
    private String message;

    public ZeroSizeException() {
        super();
    }

    public ZeroSizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
