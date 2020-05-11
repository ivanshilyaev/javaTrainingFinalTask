package ft.training.by.dao.interfaces;

import ft.training.by.bean.User;

import java.util.Optional;

public interface UserDao extends Dao<Integer, User> {
    Optional<User> read(String login, char[] password);

    boolean isLoginPresented(String login);
}
