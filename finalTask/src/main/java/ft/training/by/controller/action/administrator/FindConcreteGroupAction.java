package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindConcreteGroupAction extends AdministratorAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            int groupNum = Integer.parseInt(request.getParameter("groupNum"));
            StudentService studentService = factory.createService(StudentService.class).orElseThrow(ServiceException::new);
            List<Student> groupList = studentService.findByGroup(groupNum);
            request.getSession().setAttribute("groupList", groupList);
            if (!groupList.isEmpty()) {
                request.getSession().setAttribute("currentGroupStudent", groupList.get(0));
            }
        } catch (NumberFormatException e) {

        }
        return null;
    }
}
