package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Student;
import ft.training.by.bean.Subgroup;
import ft.training.by.bean.User;
import ft.training.by.bean.enums.Role;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.StudentService;
import ft.training.by.service.interfaces.SubgroupService;
import ft.training.by.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddStudentAction extends AdministratorAction {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_SURNAME = "surname";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_SUBGROUP = "subgroup";
    private static final String PARAM_NAME_LOGIN = "login";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        User authorizedUser = (User) request.getSession().getAttribute("authorizedUser");
        Student currentStudent = (Student) request.getSession().getAttribute("currentGroupStudent");
        String surname = request.getParameter(PARAM_NAME_SURNAME);
        String name = request.getParameter(PARAM_NAME_NAME);
        String patronymic = request.getParameter(PARAM_NAME_PATRONYMIC);
        String subgroupNum = request.getParameter(PARAM_NAME_SUBGROUP);
        String login = request.getParameter(PARAM_NAME_LOGIN);

        // валидация

        if (surname != null && name != null && patronymic != null &&
                subgroupNum != null && login != null) {
            // подгруппа
            Subgroup subgroup = new Subgroup();
            subgroup.setGroup(currentStudent.getSubgroup().getGroup());
            subgroup.setSubgroupNumber(subgroupNum.charAt(0));
            // пользователь
            User user = new User(login, new char[]{'1', '1', '1', '1', '1'}, Role.STUDENT,
                    surname, name, patronymic);
            // подгруппа
            SubgroupService subgroupService = factory.createService(SubgroupService.class).orElseThrow(ServiceException::new);
            subgroup = subgroupService.findBySubgroupNumberAndGroupId(subgroupNum.charAt(0), currentStudent.getSubgroup().getGroup().getId()).orElse(null);

            // добавление нового пользователя
            UserService userService = factory.createService(UserService.class).orElseThrow(ServiceException::new);
            int userId = userService.create(user);
            int studentId = -1;
            if (userId != -1) {
                // добавление нового студента
                /*
                 * Для создания новго студента нужен id пользователя
                 * и id подгруппы
                 */
                user = userService.read(userId).orElse(null);
                Student student = new Student(user, subgroup);
                StudentService studentService = factory.createService(StudentService.class).orElseThrow(ServiceException::new);
                studentId = studentService.create(student);
                student = studentService.read(studentId).orElse(null);
                List<Student> groupList = (List<Student>) request.getSession().getAttribute("groupList");
                groupList.add(student);
                request.getSession().setAttribute("groupList", groupList);
                if (studentId != -1) {
                    request.setAttribute("studentAddedMessage",
                            "Новый студент был успешно добавлен");
                    LOGGER.info(String.format("New student \"%s\" with identity %d has been added successfully",
                            student.getUser().getLogin(), student.getId()));
                }
            }
            if (userId == -1 || studentId == -1) {
                request.setAttribute("studentAddedMessage",
                        "Произошла ошибка ввода данных");
                LOGGER.warn(String.format("Incorrect data was found when user \"%s\" tried to add new student",
                        authorizedUser.getLogin()));
            }
        }
        return null;
    }
}
