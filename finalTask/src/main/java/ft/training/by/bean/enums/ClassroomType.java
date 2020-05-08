package ft.training.by.bean.enums;

public enum ClassroomType {
    SEMINAR("Практическая"),
    LECTURE("Лекционная");

    private String name;

    ClassroomType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ClassroomType getById(int id) {
        return ClassroomType.values()[id];
    }
}
