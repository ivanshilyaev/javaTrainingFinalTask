package ft.training.by.validator;

import ft.training.by.bean.User;
import ft.training.by.validator.exception.ValidationException;

import javax.servlet.http.HttpServletRequest;

public class UserValidator implements Validator<User> {
    private static final String PARAM_NAME_SURNAME = "surname";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_LOGIN = "login";

    @Override
    public User validate(HttpServletRequest request) throws ValidationException {
        User user = new User();
        String parameter = request.getParameter(PARAM_NAME_SURNAME);
        if (parameter != null && !parameter.isEmpty()) {
            user.setSurname(parameter);
        } else {
            throw new ValidationException(PARAM_NAME_SURNAME, parameter);
        }
        parameter = request.getParameter(PARAM_NAME_NAME);
        if (parameter != null && !parameter.isEmpty()) {
            user.setName(parameter);
        } else {
            throw new ValidationException(PARAM_NAME_NAME, parameter);
        }
        parameter = request.getParameter(PARAM_NAME_PATRONYMIC);
        if (parameter != null && !parameter.isEmpty()) {
            user.setPatronymic(parameter);
        } else {
            throw new ValidationException(PARAM_NAME_PATRONYMIC, parameter);
        }
        parameter = request.getParameter(PARAM_NAME_LOGIN);
        if (parameter != null && !parameter.isEmpty()) {
            user.setLogin(parameter);
        } else {
            throw new ValidationException(PARAM_NAME_LOGIN, parameter);
        }
        return user;
    }
}
