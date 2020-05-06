package ft.training.by.bean;

import java.util.Objects;

public class Subject extends Entity {
    private String name;

    public Subject() {
    }

    public Subject(int id) {
        super(id);
    }

    public Subject(int id, String name) {
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
        if (!super.equals(o)) return false;
        Subject subject = (Subject) o;
        return name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
