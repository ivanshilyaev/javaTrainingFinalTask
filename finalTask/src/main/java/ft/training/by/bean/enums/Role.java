package ft.training.by.bean.enums;

public enum Role {
    STUDENT,
    ADMINISTRATOR,
    TUTOR;

    public static Role getById(int id) {
        return Role.values()[id];
    }
}
