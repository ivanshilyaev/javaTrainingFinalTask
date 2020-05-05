package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Student;
import ft.training.by.bean.User;
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
        String studentId = request.getParameter("studentId");
        if (studentId != null) {
            int id = Integer.parseInt(studentId);
            StudentService studentService = factory.createService(StudentService.class).orElseThrow(ServiceException::new);
            Student student = studentService.findEntityById(id).orElse(null);
            int userId = student.getId();

            UserService userService = factory.createService(UserService.class).orElseThrow(ServiceException::new);
            User user = userService.findEntityById(userId).orElse(null);
        }
        return null;
    }
}
