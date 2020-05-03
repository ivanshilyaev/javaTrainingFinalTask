package ft.training.by.controller.action.student;

import ft.training.by.bean.Student;
import ft.training.by.service.interfaces.StudentService;
import ft.training.by.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindGroupStudentsAction extends StudentAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        StudentService studentService = factory.createService(StudentService.class).orElseThrow(ServiceException::new);
        Student student = (Student) request.getSession().getAttribute("authorizedStudent");
        List<Student> groupList = studentService.findByGroup(student.getSubgroup().getGroup().getGroupNumber());
        request.getSession().setAttribute("groupList", groupList);
        return null;
    }
}
