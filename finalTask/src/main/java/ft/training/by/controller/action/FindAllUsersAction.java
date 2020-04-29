package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.service.ServiceFactory;
import ft.training.by.service.ServiceFactoryImpl;
import ft.training.by.service.UserService;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllUsersAction extends AuthorizedUserAction {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException {
        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        UserService userService = serviceFactory.createService(UserService.class).orElseThrow(ServiceException::new);
        List<User> list = userService.findAll();
        request.getSession().setAttribute("list", list);
        return null;
    }
}
