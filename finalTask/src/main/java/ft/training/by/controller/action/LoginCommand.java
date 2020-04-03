package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.controller.resource.ConfigurationManager;
import ft.training.by.controller.resource.MessageManager;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.mysql.TransactionFactoryImpl;
import ft.training.by.service.ServiceFactory;
import ft.training.by.service.ServiceFactoryImpl;
import ft.training.by.service.UserService;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            ServiceFactory factory = new ServiceFactoryImpl(new TransactionFactoryImpl());
            UserService userService = factory.createService(UserService.class);
            User user = userService.findByLoginAndPassword(login, password.toCharArray());
            if (user != null) {
                request.setAttribute("user", user.getName());
                page = ConfigurationManager.getProperty("path.page.main");
                return page;
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute("errorLoginPasswordMessage", MessageManager.getProperty("message.loginerror"));
        page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
