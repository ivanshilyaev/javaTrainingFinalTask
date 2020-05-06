package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Group;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.GroupService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllGroupsAction extends AdministratorAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        GroupService groupService = factory.createService(GroupService.class).orElseThrow(ServiceException::new);
        List<Group> groups = groupService.read();
        request.getSession().setAttribute("listGroups", groups);
        return null;
    }
}
