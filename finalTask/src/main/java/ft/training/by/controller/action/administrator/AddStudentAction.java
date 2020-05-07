package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Group;
import ft.training.by.bean.Student;
import ft.training.by.bean.Subgroup;
import ft.training.by.bean.User;
import ft.training.by.bean.enums.Role;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.GroupService;
import ft.training.by.service.interfaces.StudentService;
import ft.training.by.service.interfaces.SubgroupService;
import ft.training.by.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddStudentAction extends AdministratorAction {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_SURNAME = "surname";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_SUBGROUP = "subgroup";
    private static final String PARAM_NAME_LOGIN = "login";

    private static final String PARAM_NAME_GROUP_NUMBER = "groupNum";
    private static final String PARAM_NAME_COURSE_NUMBER = "courseNum";
    private static final String PARAM_NAME_FACULTY_ID = "facultyId";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        User authorizedUser = (User) request.getSession().getAttribute("authorizedUser");
        int groupNum;
        int courseNum;
        int facultyId;
        try {
            groupNum = Integer.parseInt(request.getParameter(PARAM_NAME_GROUP_NUMBER));
            courseNum = Integer.parseInt(request.getParameter(PARAM_NAME_COURSE_NUMBER));
            facultyId = Integer.parseInt(request.getParameter(PARAM_NAME_FACULTY_ID));
            request.getSession().setAttribute(PARAM_NAME_GROUP_NUMBER, groupNum);
            request.getSession().setAttribute(PARAM_NAME_COURSE_NUMBER, courseNum);
            request.getSession().setAttribute(PARAM_NAME_FACULTY_ID, facultyId);
        } catch (Exception e) {
            groupNum = (int) request.getSession().getAttribute(PARAM_NAME_GROUP_NUMBER);
            courseNum = (int) request.getSession().getAttribute(PARAM_NAME_COURSE_NUMBER);
            facultyId = (int) request.getSession().getAttribute(PARAM_NAME_FACULTY_ID);
        }

        String surname = request.getParameter(PARAM_NAME_SURNAME);
        String name = request.getParameter(PARAM_NAME_NAME);
        String patronymic = request.getParameter(PARAM_NAME_PATRONYMIC);
        String subgroupNum = request.getParameter(PARAM_NAME_SUBGROUP);
        String login = request.getParameter(PARAM_NAME_LOGIN);

        // валидация

        if (surname != null && name != null && patronymic != null &&
                subgroupNum != null && login != null) {
            // группа
            GroupService groupService = factory.createService(GroupService.class);
            Group group = groupService.findByGroupCourseFaculty(groupNum, courseNum, facultyId).orElse(null);
            // подгруппа
            SubgroupService subgroupService = factory.createService(SubgroupService.class);
            Subgroup subgroup = subgroupService.findBySubgroupNumberAndGroupId(subgroupNum.charAt(0), group.getId()).orElse(null);
            // пользователь
            User user = new User(login, new char[]{'1', '1', '1', '1', '1'}, Role.STUDENT,
                    surname, name, patronymic);
            UserService userService = factory.createService(UserService.class);
            int userId = userService.create(user);
            int studentId = -1;
            if (userId != -1) {
                // студент
                Student student = new Student(user, subgroup);
                StudentService studentService = factory.createService(StudentService.class);
                studentId = studentService.create(student);
                if (studentId != -1) {
                    request.getSession().removeAttribute(PARAM_NAME_GROUP_NUMBER);
                    request.getSession().removeAttribute(PARAM_NAME_COURSE_NUMBER);
                    request.getSession().removeAttribute(PARAM_NAME_FACULTY_ID);

                    Forward forward = new Forward("/students/concreteGroup.html");
                    forward.getAttributes().put("message",
                            "Новый студент был успешно добавлен");
                    forward.getAttributes().put("groupNum", groupNum);
                    forward.getAttributes().put("courseNum", courseNum);
                    forward.getAttributes().put("facultyId", facultyId);
                    LOGGER.info(String.format("New student \"%s\" with identity %d has been added successfully",
                            student.getUser().getLogin(), student.getId()));
                    return forward;
                }
            }
            request.setAttribute("message",
                    "Произошла ошибка ввода данных");
            LOGGER.warn(String.format("Incorrect data was found when user \"%s\" tried to add new student",
                    authorizedUser.getLogin()));
        }
        return null;
    }
}
