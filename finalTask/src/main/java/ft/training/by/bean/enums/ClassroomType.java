package ft.training.by.bean.enums;

public enum ClassroomType {
    SEMINAR,
    LECTURE;

    public static ClassroomType getById(int id) {
        return ClassroomType.values()[id];
    }
}
