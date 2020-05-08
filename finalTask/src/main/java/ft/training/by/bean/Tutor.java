package ft.training.by.bean;

import java.util.Objects;

public class Tutor extends Entity {
    private User user;
    private String position;
    private String degree;

    public Tutor() {

    }

    public Tutor(int id) {
        super(id);
    }

    public Tutor(User user, String position, String degree) {
        this.user = user;
        this.position = position;
        this.degree = degree;
    }

    public Tutor(int id, User user, String position, String degree) {
        super(id);
        this.user = user;
        this.position = position;
        this.degree = degree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tutor tutor = (Tutor) o;
        return user.equals(tutor.user) &&
                position.equals(tutor.position) &&
                degree.equals(tutor.degree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, position, degree);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id='" + getId() + '\'' +
                ", user=" + user.toString() +
                ", position='" + position + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
