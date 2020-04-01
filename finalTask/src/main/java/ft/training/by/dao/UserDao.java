package ft.training.by.dao;

import ft.training.by.bean.User;

public interface UserDao extends Dao<Integer, User> {
    // special methods for user
    User findByLoginAndPassword(String login, char[] password);
}
