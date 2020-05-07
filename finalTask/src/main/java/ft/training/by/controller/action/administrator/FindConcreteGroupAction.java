package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;

public class FindConcreteGroupAction extends AdministratorAction {
    private static final String PARAM_GROUP_NUMBER = "groupNum";
    private static final String PARAM_COURSE_NUMBER = "courseNum";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int groupNum;
        int courseNum;
        try {
            groupNum = Integer.parseInt(request.getParameter(PARAM_GROUP_NUMBER));
            courseNum = Integer.parseInt(request.getParameter(PARAM_COURSE_NUMBER));
            request.setAttribute("groupNum", groupNum);
            request.setAttribute("courseNum", courseNum);
        } catch (NumberFormatException e) {
            groupNum = (int) request.getAttribute(PARAM_GROUP_NUMBER);
            courseNum = (int) request.getAttribute(PARAM_COURSE_NUMBER);
        }
        StudentService studentService = factory.createService(StudentService.class);
        List<Student> groupList = studentService.findByGroupAndCourse(groupNum, courseNum);
        groupList.sort(Comparator.comparing(student -> student.getUser().getSurname()));
        request.setAttribute("groupList", groupList);
        return null;
    }
}
