package by.training.branching.branchingnextday.service;

import java.io.IOException;

public class IllegalDateException extends IOException {
    private String message;

    public IllegalDateException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
