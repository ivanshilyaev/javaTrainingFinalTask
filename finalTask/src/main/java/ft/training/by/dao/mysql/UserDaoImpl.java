package ft.training.by.dao.mysql;

import ft.training.by.bean.enums.Role;
import ft.training.by.bean.User;
import ft.training.by.dao.UserDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends DaoImpl implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_USERS =
            "SELECT id, login, password, role, surname, name, patronymic FROM user;";

    public static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT id, role, surname, name, patronymic FROM user WHERE login = ? AND password = ?;";

    public static final String SQL_UPDATE_USER =
            "UPDATE user SET login = ?, password = ?, role = ?, surname = ?, name = ?, patronymic = ? WHERE id = ?;";

    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
                    while (resultSet.next()) {
                        User user = new User();
                        fillUser(resultSet, user);
                        users.add(user);
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    } else {
                        LOGGER.error("Error while reading from DB");
                    }
                }
            } finally {
                if (statement != null) {
                    close(statement);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        } finally {
            closeConnection();
        }
        return users;
    }

    @Override
    public Optional<User> findEntityById(Integer id) throws DAOException {
        User user = null;
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
                    while (resultSet.next()) {
                        if (resultSet.getInt(1) == id) {
                            user = new User();
                            fillUser(resultSet, user);
                        }
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    } else {
                        LOGGER.error("Error while reading from DB");
                    }
                }
            } finally {
                if (statement != null) {
                    close(statement);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1, entity.getLogin());
            statement.setString(2, String.valueOf(entity.getPassword()));
            statement.setInt(3, entity.getRole().ordinal());
            statement.setString(4, entity.getSurname());
            statement.setString(5, entity.getName());
            statement.setString(6, entity.getPatronymic());
            statement.setInt(7, entity.getId());
            statement.executeUpdate();
            close(statement);
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return entity;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, char[] password) {
        User user = null;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD);
            statement.setString(1, login);
            statement.setString(2, String.valueOf(password));
            ResultSet resultSet =
                    statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getById(resultSet.getInt(2)));
                user.setSurname(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setPatronymic(resultSet.getString(5));
            }
            resultSet.close();
            close(statement);
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return Optional.ofNullable(user);
    }

    private void fillUser(ResultSet resultSet, User user) throws SQLException {
        user.setId(resultSet.getInt(1));
        user.setLogin(resultSet.getString(2));
        user.setPassword(resultSet.getString(3).toCharArray());
        int ch = resultSet.getInt(4);
        switch (ch) {
            case 0: {
                user.setRole(Role.STUDENT);
                break;
            }
            case 1: {
                user.setRole(Role.ADMINISTRATOR);
                break;
            }
            case 2: {
                user.setRole(Role.TUTOR);
                break;
            }
            default:
                break;
        }
        user.setSurname(resultSet.getString(5));
        user.setName(resultSet.getString(6));
        user.setPatronymic(resultSet.getString(7));
    }
}
