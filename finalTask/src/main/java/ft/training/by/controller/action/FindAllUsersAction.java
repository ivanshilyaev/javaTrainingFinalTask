package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.controller.resource.ConfigurationManager;
import ft.training.by.controller.resource.MessageManager;
import ft.training.by.service.ServiceFactory;
import ft.training.by.service.ServiceFactoryImpl;
import ft.training.by.service.UserService;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllUsersAction extends Action {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        try {
            ServiceFactory serviceFactory = new ServiceFactoryImpl();
            UserService userService = serviceFactory.createService(UserService.class).orElseThrow(ServiceException::new);
            List<User> list = userService.findAll();
            request.setAttribute("list", list);
            page = ConfigurationManager.getProperty("path.page.list");
            return page;
        } catch (ServiceException e) {
            LOGGER.error("Service exception in execute method", e);
        }
        request.setAttribute("errorFindAllUsersMessage", MessageManager.getProperty("message.finderror"));
        page = ConfigurationManager.getProperty("path.page.main");
        return page;
    }
}
