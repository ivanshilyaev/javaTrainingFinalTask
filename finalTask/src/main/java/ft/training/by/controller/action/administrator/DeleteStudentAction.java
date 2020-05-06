package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.StudentService;
import ft.training.by.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteStudentAction extends AdministratorAction {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_ID = "studentId";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String studentId = request.getParameter(PARAM_NAME_ID);
        if (studentId != null) {
            try {
                int groupNum = Integer.parseInt(request.getParameter("groupNum"));
                int id = Integer.parseInt(studentId);
                StudentService studentService = factory.createService(StudentService.class).orElseThrow(ServiceException::new);
                Student student = studentService.findEntityById(id).orElse(null);
                int userId = student.getId();

                boolean studentDeleted = studentService.delete(id);
                if (studentDeleted) {
                    UserService userService = factory.createService(UserService.class).orElseThrow(ServiceException::new);
                    boolean userDeleted = userService.delete(userId);
                    if (userDeleted) {
                        request.getSession().setAttribute("studentDeletedMessage",
                                "Студент был успешно удалён");
                        LOGGER.info(String.format("User \"%s\" deleted user with identity %d", getAuthorizedUser().getLogin(), id));
                        Forward forward = new Forward("/students/concreteGroup.html");
                        forward.getAttributes().put("groupNum", groupNum);
                        return forward;
                    }
                }
                request.getSession().setAttribute("studentDeletedMessage",
                        "Ошибка при попытке удалить студента");
                LOGGER.warn(String.format("Incorrect data was found when user \"%s\" tried to delete user", getAuthorizedUser().getLogin()));
            } catch (NumberFormatException e) {

            }
        }
        return null;
    }
}