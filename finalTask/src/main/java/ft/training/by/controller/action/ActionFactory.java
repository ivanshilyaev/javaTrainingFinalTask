package ft.training.by.controller.action;

import ft.training.by.controller.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public final class ActionFactory {
    private ActionFactory() {
    }

    public static ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand command = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return command;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return command;
    }
}
