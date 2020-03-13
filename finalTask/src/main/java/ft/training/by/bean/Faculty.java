package ft.training.by.bean;

import java.util.Objects;

public class Faculty extends Entity {
    private String name;
    private String dean;

    public Faculty() {
    }

    public Faculty(int id) {
        super(id);
    }

    public Faculty(int id, String name, String dean) {
        super(id);
        this.name = name;
        this.dean = dean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name.equals(faculty.name) &&
                dean.equals(faculty.dean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dean);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", dean='" + dean + '\'' +
                '}';
    }
}
