package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends AuthorizedUserAction {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        User user = getAuthorizedUser();
        LOGGER.info(String.format("User \"%s\" is logged out", user.getLogin()));
        request.getSession(false).invalidate();
        return new Forward("/login.html");
    }
}
