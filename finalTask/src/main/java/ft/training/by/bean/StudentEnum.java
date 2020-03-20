package ft.training.by.bean;

public enum StudentEnum {
    STUDENTS("students"),
    STUDENT("student"),
    USER("user"),
    SUBGROUP("subgroup"),
    GROUP("group"),
    FACULTY("faculty"),
    ROLE("role"),
    ID("id"),
    LOGIN("login"),
    PASSWORD("password"),
    SURNAME("surname"),
    NAME("name"),
    PATRONYMIC("patronymic"),
    SUBGROUPNUMBER("subgroupNumber"),
    GROUPNUMBER("groupNumber"),
    COURSENUMBER("courseNumber");

    private String value;

    StudentEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
