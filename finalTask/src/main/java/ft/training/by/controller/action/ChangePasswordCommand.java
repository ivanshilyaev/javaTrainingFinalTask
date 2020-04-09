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

import java.util.Arrays;

public class ChangePasswordCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_OLD_PASSWORD = "old_password";
    private static final String PARAM_NAME_NEW_PASSWORD = "new_password";
    private static final String PARAM_NAME_NEW_PASSWORD_AGAIN = "new_password_again";

    @Override
    public String execute(SessionRequestContent content) {
        String page = null;
        String oldPassword = content.getRequestParameters().get(PARAM_NAME_OLD_PASSWORD)[0];
        String newPassword = content.getRequestParameters().get(PARAM_NAME_NEW_PASSWORD)[0];
        String newPasswordAgain = content.getRequestParameters().get(PARAM_NAME_NEW_PASSWORD_AGAIN)[0];
        User currentUser = (User) content.getSessionAttributes().get("current_user");
        System.out.println(Arrays.equals(currentUser.getPassword(), oldPassword.toCharArray()));
        if (!Arrays.equals(currentUser.getPassword(), oldPassword.toCharArray())) {
            System.out.println(currentUser.getPassword());
            System.out.println(oldPassword);
            content.getRequestAttributes().put("invalidOldPassword",
                    MessageManager.getProperty("message.oldPasswordError"));
            page = ConfigurationManager.getProperty("path.page.password");
            return page;
        }
        if (!newPassword.equals(newPasswordAgain)) {
            content.getRequestAttributes().put("passwordRepeatedIncorrectly",
                    MessageManager.getProperty("message.newPasswordError"));
            page = ConfigurationManager.getProperty("path.page.password");
            return page;
        }
        if (oldPassword.equals(newPassword)) {
            content.getRequestAttributes().put("samePassword",
                    MessageManager.getProperty("message.samePasswordError"));
            page = ConfigurationManager.getProperty("path.page.password");
            return page;
        }
        currentUser.setPassword(newPassword.toCharArray());
        try {
            ServiceFactory serviceFactory = new ServiceFactoryImpl();
            UserService userService = serviceFactory.createService(UserService.class).orElseThrow(ServiceException::new);
            userService.update(currentUser);
            content.setInvalidateSession(true);
            page = ConfigurationManager.getProperty("path.page.index");
            return page;
        } catch (ServiceException e) {
            LOGGER.error("Service exception in execute method", e);
        }
        return page;
    }
}
