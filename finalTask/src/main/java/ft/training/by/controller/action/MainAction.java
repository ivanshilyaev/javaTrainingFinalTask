package ft.training.by.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainAction extends AuthorizedUserAction {
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) {
        @SuppressWarnings("unchecked")
        List<MenuItem> menu = (List<MenuItem>) request.getSession(false).getAttribute("menu");
        return new Forward(menu.get(0).getUrl());
    }
}
