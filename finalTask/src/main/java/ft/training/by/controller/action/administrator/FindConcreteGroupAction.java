package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindConcreteGroupAction extends AdministratorAction {
    private static final String PARAM_GROUP_NUMBER = "groupNum";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String line = request.getParameter(PARAM_GROUP_NUMBER);
            int groupNum;
            if (line != null) {
                groupNum = Integer.parseInt(request.getParameter(PARAM_GROUP_NUMBER));
            } else {
                groupNum = (int) request.getAttribute(PARAM_GROUP_NUMBER);
            }
            StudentService studentService = factory.createService(StudentService.class);
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
