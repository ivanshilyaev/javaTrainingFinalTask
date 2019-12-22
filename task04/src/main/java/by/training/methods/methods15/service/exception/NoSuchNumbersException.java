package by.training.methods.methods15.service.exception;

import java.io.IOException;

public class NoSuchNumbersException extends IOException {
    private String message;

    public NoSuchNumbersException() {
        super();
    }

    public NoSuchNumbersException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
