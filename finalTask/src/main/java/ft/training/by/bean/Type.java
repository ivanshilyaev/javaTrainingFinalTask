package ft.training.by.bean;

public enum Type {
    SEMINAR,
    LECTURE;

    public static Type getById(int id) {
        return Type.values()[id];
    }
}
