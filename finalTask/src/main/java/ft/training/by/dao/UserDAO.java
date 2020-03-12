package ft.training.by.dao;

import ft.training.by.bean.Role;
import ft.training.by.bean.User;
import ft.training.by.service.ConnectorDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<Integer, User> {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_USERS =
            "SELECT id, login, password, role, surname, name, patronymic FROM user;";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
                    while (resultSet.next()) {
                        User user = new User();
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
                } else {
                    LOGGER.error("Error while reading from DB");
                }
            }
        } catch (SQLException e) {
            LOGGER.error("DB connection error: " + e.getMessage());
        } finally {
            close(connection);
        }
        return users;
    }

    @Override
    public User findEntityById(Integer id) {
        return null;
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
        return null;
    }
}