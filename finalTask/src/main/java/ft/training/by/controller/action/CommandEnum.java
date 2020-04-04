package ft.training.by.controller.action;

public enum CommandEnum {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand());

    private ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
