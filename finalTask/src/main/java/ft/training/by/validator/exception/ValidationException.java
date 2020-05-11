package ft.training.by.validator.exception;

public class ValidationException extends Exception {
    public ValidationException(String parameter, String value) {
        super(String.format("Empty or incorrect \"%s\" parameter: %s", parameter, value));
    }
}
