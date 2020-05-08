package ft.training.by.bean.enums;

public enum ClassType {
    LECTURE("Лекция"),
    PRACTICE("Практика");

    private String name;

    ClassType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ClassType getById(int id) {
        return ClassType.values()[id];
    }
}
