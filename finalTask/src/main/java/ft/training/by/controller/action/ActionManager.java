package ft.training.by.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionManager {
    Action.Forward execute(Action action, HttpServletRequest request, HttpServletResponse response);

    void close();
}