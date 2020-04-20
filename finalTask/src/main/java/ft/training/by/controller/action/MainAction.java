package ft.training.by.controller.action;

import ft.training.by.controller.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ConfigurationManager.getProperty("path.page.password");
    }
}
