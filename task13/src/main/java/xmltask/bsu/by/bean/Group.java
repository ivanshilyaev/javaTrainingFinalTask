package xmltask.bsu.by.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "group", propOrder = {"groupNumber", "courseNumber", "faculty"})
public class Group extends Entity {
    private int groupNumber;
    private int courseNumber;
    private Faculty faculty;

    public Group() {
    }

    public Group(int id) {
        super(id);
    }

    public Group(int id, int groupNumber, int courseNumber, Faculty faculty) {
        super(id);
        this.groupNumber = groupNumber;
        this.courseNumber = courseNumber;
        this.faculty = faculty;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupNumber == group.groupNumber &&
                courseNumber == group.courseNumber &&
                faculty.equals(group.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, courseNumber, faculty);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", courseNumber=" + courseNumber +
                ", faculty=" + faculty.toString() +
                '}';
    }
}
