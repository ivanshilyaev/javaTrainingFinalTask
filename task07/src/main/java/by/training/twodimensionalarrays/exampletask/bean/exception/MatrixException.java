package by.training.twodimensionalarrays.exampletask.bean.exception;

public class MatrixException extends Exception {
    private String message;

    public MatrixException() {
        super();
    }

    public MatrixException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
