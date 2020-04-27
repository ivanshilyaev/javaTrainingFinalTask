package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.bean.enums.Role;
import ft.training.by.controller.resource.MessageManager;
import ft.training.by.service.UserService;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LoginAction extends Action {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private static Map<Role, List<MenuItem>> menu = new ConcurrentHashMap<>();

    static {
        menu.put(Role.STUDENT, new ArrayList<>(Arrays.asList(
                new MenuItem("главная страница", "/main.html")
        )));
        menu.put(Role.ADMINISTRATOR, new ArrayList<>(Arrays.asList(
                // !
                new MenuItem("главная страница", "/main.html")
        )));
        menu.put(Role.TUTOR, new ArrayList<>(Arrays.asList(
                // !
                new MenuItem("главная страница", "/main.html")
        )));
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Inside login action");
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if (login != null && password != null) {
            try {
                UserService userService = factory.createService(UserService.class).orElseThrow(ServiceException::new);
                User user = userService.findByLoginAndPassword(login, password.toCharArray()).orElseThrow(ServiceException::new);
                if (user != null) {
                    // для привествия пользователя на главной странице
                    request.setAttribute("user", user.getName());
                    // для разделения пользователей
                    request.getSession().setAttribute("authorizedUser", user);
                    request.getSession().setAttribute("menu", menu.get(user.getRole()));
                    LOGGER.info(String.format("user \"%s\" is logged in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
                    return new Forward("/index.html");
                }
            } catch (ServiceException e) {
                LOGGER.error("Service exception in execute method", e);
            }
        }
        // request.setAttribute("errorLoginPasswordMessage", MessageManager.getProperty("message.loginerror"));
        return null;
    }
}
