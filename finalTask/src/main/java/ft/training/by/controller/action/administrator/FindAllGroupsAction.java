package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Group;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.GroupService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllGroupsAction extends AdministratorAction {
    private static final String PARAM_GROUP_FACULTY_ID = "facultyId";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            int facultyId = Integer.parseInt(request.getParameter(PARAM_GROUP_FACULTY_ID));
            request.setAttribute("facultyId", facultyId);
            GroupService groupService = factory.createService(GroupService.class);
            List<Group> groups = groupService.findByFacultyId(facultyId);
            request.setAttribute("listGroups", groups);
        } catch (NumberFormatException e) {
        }
        return null;
    }
}
