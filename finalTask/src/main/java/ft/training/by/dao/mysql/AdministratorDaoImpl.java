package ft.training.by.dao.mysql;

import ft.training.by.bean.Administrator;
import ft.training.by.bean.User;
import ft.training.by.dao.interfaces.AdministratorDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministratorDaoImpl extends DaoImpl implements AdministratorDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_ADMINISTRATORS =
            "SELECT id, position, user_id FROM administrator;";

    private static final String SQL_SELECT_ADMINISTRATOR_BY_ID =
            "SELECT id, position, user_id FROM administrator" +
                    "  WHERE id = ?;";

    private static final String SQL_SELECT_ADMINISTRATOR_BY_USER_ID =
            "SELECT id, position, user_id FROM administrator" +
                    "  WHERE user_id = ?;";


    @Override
    public Integer create(Administrator entity) {
        return BAD_CREATION_CODE;
    }

    @Override
    public List<Administrator> read() throws DAOException {
        List<Administrator> admins = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_ADMINISTRATORS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Administrator administrator = new Administrator();
                fillAdministrator(resultSet, administrator);
                admins.add(administrator);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return admins;
    }

    @Override
    public Optional<Administrator> read(Integer id) throws DAOException {
        Administrator administrator = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ADMINISTRATOR_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                administrator = new Administrator();
                fillAdministrator(resultSet, administrator);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(administrator);
    }

    @Override
    public void update(Administrator entity) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Administrator entity) {
        return false;
    }

    @Override
    public Optional<Administrator> findByUserId(Integer id) throws DAOException {
        Administrator administrator = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ADMINISTRATOR_BY_USER_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                administrator = new Administrator();
                fillAdministrator(resultSet, administrator);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(administrator);
    }

    public void fillAdministrator(ResultSet resultSet, Administrator administrator)
            throws SQLException, DAOException {
        administrator.setId(resultSet.getInt(1));
        administrator.setPosition(resultSet.getString(2));
        int userId = resultSet.getInt(3);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(connection);
        User user = userDao.read(userId).orElse(null);
        administrator.setUser(user);
    }
}
