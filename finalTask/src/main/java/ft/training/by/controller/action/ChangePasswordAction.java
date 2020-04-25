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
import java.util.Arrays;

public class ChangePasswordAction extends Action {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_OLD_PASSWORD = "old_password";
    private static final String PARAM_NAME_NEW_PASSWORD = "new_password";
    private static final String PARAM_NAME_NEW_PASSWORD_AGAIN = "new_password_again";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = ConfigurationManager.getProperty("path.page.password");
        String oldPassword = request.getParameter(PARAM_NAME_OLD_PASSWORD);
        String newPassword = request.getParameter(PARAM_NAME_NEW_PASSWORD);
        String newPasswordAgain = request.getParameter(PARAM_NAME_NEW_PASSWORD_AGAIN);
        User currentUser = (User) request.getSession().getAttribute("authorizedUser");
        if (!Arrays.equals(currentUser.getPassword(), oldPassword.toCharArray())) {
            System.out.println(currentUser.getPassword());
            System.out.println(oldPassword);
            request.setAttribute("message",
                    MessageManager.getProperty("message.oldPasswordError"));
            return page;
        }
        if (!newPassword.equals(newPasswordAgain)) {
            request.setAttribute("message",
                    MessageManager.getProperty("message.newPasswordError"));
            return page;
        }
        if (oldPassword.equals(newPassword)) {
            request.setAttribute("message",
                    MessageManager.getProperty("message.samePasswordError"));
            return page;
        }
        currentUser.setPassword(newPassword.toCharArray());
        try {
            ServiceFactory serviceFactory = new ServiceFactoryImpl();
            UserService userService = serviceFactory.createService(UserService.class).orElseThrow(ServiceException::new);
            userService.update(currentUser);
            request.getSession().invalidate();
            request.setAttribute("message",
                    MessageManager.getProperty("message.passwordChanged"));
            return page;
        } catch (ServiceException e) {
            LOGGER.error("Service exception in execute method", e);
        }
        return page;
    }
}
