package ft.training.by.controller.action;

public enum CommandEnum {
    LOGIN(new LoginAction()),
    LOGOUT(new LogoutAction()),
    FIND_ALL_USERS(new FindAllUsersAction()),
    CHANGE_PASSWORD(new ChangePasswordAction());

    private Action command;

    CommandEnum(Action command) {
        this.command = command;
    }

    public Action getCommand() {
        return command;
    }
}
