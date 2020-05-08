package ft.training.by.bean;

import java.util.Objects;

public class Group extends Entity {
    private int groupNumber;
    private int courseNumber;

    public Group() {
    }

    public Group(int id) {
        super(id);
    }

    public Group(int id, int groupNumber, int courseNumber) {
        super(id);
        this.groupNumber = groupNumber;
        this.courseNumber = courseNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupNumber == group.groupNumber &&
                courseNumber == group.courseNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, courseNumber);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + getId() + '\'' +
                ", groupNumber=" + groupNumber +
                ", courseNumber=" + courseNumber +
                '}';
    }
}
