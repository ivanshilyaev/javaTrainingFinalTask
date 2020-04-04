package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.controller.SessionRequestContent;
import ft.training.by.controller.resource.ConfigurationManager;
import ft.training.by.controller.resource.MessageManager;
import ft.training.by.service.ServiceFactory;
import ft.training.by.service.ServiceFactoryImpl;
import ft.training.by.service.UserService;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(SessionRequestContent content) {
        String page;
        String login = content.getRequestParameters().get(PARAM_NAME_LOGIN)[0];
        String password = content.getRequestParameters().get(PARAM_NAME_PASSWORD)[0];
        try {
            ServiceFactory factory = new ServiceFactoryImpl();
            UserService userService = factory.createService(UserService.class).orElseThrow(ServiceException::new);
            User user = userService.findByLoginAndPassword(login, password.toCharArray()).orElseThrow(ServiceException::new);
            if (user != null) {
                content.getRequestAttributes().put("user", user.getName());
                page = ConfigurationManager.getProperty("path.page.main");
                return page;
            }
        } catch (ServiceException e) {
            LOGGER.error("Service exception in execute method", e);
        }
        content.getRequestAttributes().put("errorLoginPasswordMessage", MessageManager.getProperty("message.loginerror"));
        page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
