package ft.training.by.dao.mysql;

import ft.training.by.bean.Tutor;
import ft.training.by.bean.User;
import ft.training.by.dao.interfaces.TutorDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TutorDaoImpl extends DaoImpl implements TutorDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_TUTORS =
            "SELECT id, position, degree, user_id FROM tutor;";

    @Override
    public List<Tutor> findAll() throws DAOException {
        List<Tutor> tutors = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_TUTORS);
                    while (resultSet.next()) {
                        Tutor tutor = new Tutor();
                        fillTutor(tutor, resultSet);
                        tutors.add(tutor);
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
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
        return tutors;
    }

    @Override
    public Optional<Tutor> findEntityById(Integer id) throws DAOException {
        Tutor tutor = null;
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_TUTORS);
                    while (resultSet.next()) {
                        if (resultSet.getInt(1) == id) {
                            tutor = new Tutor();
                            fillTutor(tutor, resultSet);
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
        return Optional.ofNullable(tutor);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Tutor entity) {
        return false;
    }

    @Override
    public boolean create(Tutor entity) {
        return false;
    }

    @Override
    public Tutor update(Tutor entity) {
        return null;
    }

    private void fillTutor(Tutor tutor, ResultSet resultSet) throws SQLException, DAOException {
        tutor.setId(resultSet.getInt(1));
        tutor.setPosition(resultSet.getString(2));
        tutor.setDegree(resultSet.getString(3));
        int userID = resultSet.getInt(4);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(connection);
        User user = userDao.findEntityById(userID).orElse(null);
        tutor.setUser(user);
    }
}
