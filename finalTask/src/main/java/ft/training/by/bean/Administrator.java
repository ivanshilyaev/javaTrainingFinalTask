package ft.training.by.bean;

import java.util.Objects;

public class Administrator extends Entity {
    private String position;
    private User user;

    public Administrator() {
    }

    public Administrator(int id) {
        super(id);
    }

    public Administrator(int id, String position, User user) {
        super(id);
        this.position = position;
        this.user = user;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return position.equals(that.position) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, user);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id='" + getId() + '\'' +
                ", position='" + position + '\'' +
                ", user=" + user +
                '}';
    }
}
