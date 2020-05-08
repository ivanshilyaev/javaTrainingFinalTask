package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Tutor;
import ft.training.by.bean.User;
import ft.training.by.bean.enums.Role;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TutorService;
import ft.training.by.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTutorAction extends AdministratorAction {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_SURNAME = "surname";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_POSITION = "position";
    private static final String PARAM_NAME_DEGREE = "degree";
    private static final String PARAM_NAME_LOGIN = "login";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String surname = request.getParameter(PARAM_NAME_SURNAME);
        String name = request.getParameter(PARAM_NAME_NAME);
        String patronymic = request.getParameter(PARAM_NAME_PATRONYMIC);
        String position = request.getParameter(PARAM_NAME_POSITION);
        String degree = request.getParameter(PARAM_NAME_DEGREE);
        String login = request.getParameter(PARAM_NAME_LOGIN);

        // валидация

        if (surname != null && name != null && patronymic != null &&
                position != null && degree != null && login != null) {
            User user = new User(login, new char[]{'1', '1', '1', '1', '1'}, Role.TUTOR,
                    surname, name, patronymic);
            UserService userService = factory.createService(UserService.class);
            int userId = userService.create(user);
            int tutorId = -1;
            if (userId != -1) {
                Tutor tutor = new Tutor(user, position, degree);
                TutorService tutorService = factory.createService(TutorService.class);
                tutorId = tutorService.create(tutor);
                if (tutorId != -1) {
                    Forward forward = new Forward("/tutors/listTutors.html");
                    forward.getAttributes().put("message",
                            "Новый преподаватель был успешно добавлен");
                    LOGGER.info(String.format("New tutor \"%s\" with identity %d has been added successfully",
                            tutor.getUser().getLogin(), tutor.getId()));
                    return forward;
                }
            }
            request.setAttribute("message",
                    "Произошла ошибка ввода данных");
            LOGGER.warn(String.format("Incorrect data was found when user \"%s\" tried to add new tutor",
                    getAuthorizedUser().getLogin()));
        }
        return null;
    }
}
