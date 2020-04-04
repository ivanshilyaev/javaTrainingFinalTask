package ft.training.by.controller.action;

import ft.training.by.controller.SessionRequestContent;
import ft.training.by.controller.resource.MessageManager;

public final class ActionFactory {
    private ActionFactory() {
    }

    public static ActionCommand defineCommand(SessionRequestContent content) {
        ActionCommand command = new EmptyCommand();
        String action = content.getRequestParameters().get("command")[0];
        if (action == null || action.isEmpty()) {
            return command;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCommand();
        } catch (IllegalArgumentException e) {
            content.getRequestAttributes().put("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return command;
    }
}
