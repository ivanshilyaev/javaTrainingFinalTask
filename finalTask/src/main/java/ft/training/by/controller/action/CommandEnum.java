package ft.training.by.controller.action;

public enum CommandEnum {
    LOGIN {
        {
            command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            command = new LogoutCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
