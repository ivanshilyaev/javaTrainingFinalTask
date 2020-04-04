package ft.training.by.controller.action;

import ft.training.by.controller.SessionRequestContent;
import ft.training.by.controller.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(SessionRequestContent content) {
        String page = ConfigurationManager.getProperty("path.page.index");
        content.setInvalidateSession(true);
        return page;
    }
}
