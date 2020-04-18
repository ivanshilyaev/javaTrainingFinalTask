package ft.training.by.bean.enums;

public enum ClassType {
    LECTURE,
    PRACTICE;

    public static ClassType getById(int id) {
        return ClassType.values()[id];
    }
}
