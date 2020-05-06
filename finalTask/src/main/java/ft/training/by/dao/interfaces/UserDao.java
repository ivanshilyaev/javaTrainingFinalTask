package ft.training.by.dao.interfaces;

import ft.training.by.bean.User;

import java.util.Optional;

public interface UserDao extends Dao<Integer, User> {
    // special methods for user
    Optional<User> read(String login, char[] password);
}
