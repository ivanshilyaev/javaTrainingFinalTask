package ft.training.by.controller.action;

import ft.training.by.controller.SessionRequestContent;

public interface ActionCommand {
    String execute(SessionRequestContent content);
}
