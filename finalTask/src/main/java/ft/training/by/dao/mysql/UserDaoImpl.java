package ft.training.by.dao.mysql;

import ft.training.by.bean.enums.Role;
import ft.training.by.bean.User;
import ft.training.by.dao.interfaces.UserDao;
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

    private static final String SQL_SELECT_ALL_USERS =
            "SELECT id, login, password, role, surname, name, patronymic FROM user ORDER BY surname;";

    private static final String SQL_SELECT_USER_BY_ID =
            "SELECT id, login, password, role, surname, name, patronymic FROM user WHERE id = ?;";

    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT id, role, surname, name, patronymic FROM user WHERE login = ? AND password = ?;";

    private static final String SQL_UPDATE_USER =
            "UPDATE user SET login = ?, password = ?, role = ?, surname = ?, name = ?, patronymic = ? WHERE id = ?;";

    private static final String SQL_INSERT =
            "INSERT INTO user (login, password, role, surname, name, patronymic) VALUES (?, ?, ?, ?, ?, ?);";

    private static final String SQL_DELETE_USER_BY_ID =
            "DELETE FROM user WHERE id = ?;";

    private static final String SQL_SELECT_BY_LOGIN =
            "SELECT id FROM user WHERE login = ?";

    @Override
    public Integer create(User entity) throws DAOException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, new String(entity.getPassword()));
            statement.setInt(3, entity.getRole().ordinal());
            statement.setString(4, entity.getSurname());
            statement.setString(5, entity.getName());
            statement.setString(6, entity.getPatronymic());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                entity.setId(id);
                return id;
            } else {
                LOGGER.error("No autoincremented index after trying to add record into table user");
                return BAD_CREATION_CODE;
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
            return BAD_CREATION_CODE;
        }
    }

    @Override
    public List<User> read() throws DAOException {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_USERS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                fillUser(resultSet, user);
                users.add(user);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return users;
    }

    @Override
    public Optional<User> read(Integer id) throws DAOException {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                fillUser(resultSet, user);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User entity) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, String.valueOf(entity.getPassword()));
            statement.setInt(3, entity.getRole().ordinal());
            statement.setString(4, entity.getSurname());
            statement.setString(5, entity.getName());
            statement.setString(6, entity.getPatronymic());
            statement.setInt(7, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        boolean deleted = false;
        try (PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            deleted = true;
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return deleted;
    }

    @Override
    public Optional<User> read(String login, char[] password) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, String.valueOf(password));
            ResultSet resultSet = statement.executeQuery();
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
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean isLoginPresented(String login) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) return true;
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return false;
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
