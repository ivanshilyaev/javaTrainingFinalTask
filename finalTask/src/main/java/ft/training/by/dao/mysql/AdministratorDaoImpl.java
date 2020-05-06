package ft.training.by.dao.mysql;

import ft.training.by.bean.Administrator;
import ft.training.by.bean.User;
import ft.training.by.dao.interfaces.AdministratorDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministratorDaoImpl extends DaoImpl implements AdministratorDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_ADMINISTRATORS =
            "SELECT id, position, user_id FROM administrator;";

    @Override
    public List<Administrator> read() throws DAOException {
        List<Administrator> admins = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ADMINISTRATORS)) {
                    while (resultSet.next()) {
                        Administrator administrator = new Administrator();
                        fillAdministrator(administrator, resultSet);
                        admins.add(administrator);
                    }
                }
            } finally {

            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return admins;
    }

    @Override
    public Optional<Administrator> read(Integer id) throws DAOException {
        return Optional.empty();
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
    public Integer create(Administrator entity) {
        return BAD_CREATION_CODE;
    }


    public void fillAdministrator(Administrator administrator, ResultSet resultSet)
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
