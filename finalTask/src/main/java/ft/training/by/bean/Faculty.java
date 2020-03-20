package ft.training.by.bean;

import java.util.Objects;

public class Faculty extends Entity {
    private String name;

    public Faculty() {
    }

    public Faculty(int id) {
        super(id);
    }

    public Faculty(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name.equals(faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + getId() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
