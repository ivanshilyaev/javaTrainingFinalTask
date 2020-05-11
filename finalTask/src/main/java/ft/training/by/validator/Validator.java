package ft.training.by.validator;

import ft.training.by.bean.Entity;
import ft.training.by.validator.exception.ValidationException;

import javax.servlet.http.HttpServletRequest;

public interface Validator<T extends Entity> {
    T validate(HttpServletRequest request) throws ValidationException;
}
