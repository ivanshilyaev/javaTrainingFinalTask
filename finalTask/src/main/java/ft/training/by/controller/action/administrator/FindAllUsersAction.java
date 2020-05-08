package ft.training.by.controller.action.administrator;

import ft.training.by.bean.User;
import ft.training.by.service.interfaces.UserService;
import ft.training.by.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllUsersAction extends AdministratorAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        UserService userService = factory.createService(UserService.class);
        List<User> listUsers = userService.read();
        request.setAttribute("listUsers", listUsers);
        return null;
    }
}
