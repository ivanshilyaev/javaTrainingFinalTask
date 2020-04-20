package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.bean.enums.Role;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginAction extends Action {
    private static final Logger LOGGER = LogManager.getLogger();

    private static Map<Role, List<MenuItem>> menu = new ConcurrentHashMap<>();

    static {
        menu.put(Role.STUDENT, new ArrayList<>(Arrays.asList(
                new MenuItem("Поиск всех студентов", "/WEB-INF/jsp/list.jsp")
        )));
        menu.put(Role.ADMINISTRATOR, new ArrayList<>(Arrays.asList(
                //
        )));
        menu.put(Role.TUTOR, new ArrayList<>(Arrays.asList(
                //
        )));
    }

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            ServiceFactory factory = new ServiceFactoryImpl();
            UserService userService = factory.createService(UserService.class).orElseThrow(ServiceException::new);
            User user = userService.findByLoginAndPassword(login, password.toCharArray()).orElseThrow(ServiceException::new);
            if (user != null) {
                // для привествия пользователя на главной странице
                request.setAttribute("user", user.getName());
                // для разделения пользователей
                request.getSession().setAttribute("authorizedUser", user);
                LOGGER.info(String.format("user \"%s\" is logged in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
                page = ConfigurationManager.getProperty("path.page.main");
                return page;
            }
        } catch (ServiceException e) {
            LOGGER.error("Service exception in execute method", e);
        }
        request.setAttribute("errorLoginPasswordMessage", MessageManager.getProperty("message.loginerror"));
        page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
