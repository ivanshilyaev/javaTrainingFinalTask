package ft.training.by.dao.mysql;

import ft.training.by.bean.Tutor;
import ft.training.by.bean.User;
import ft.training.by.dao.interfaces.TutorDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TutorDaoImpl extends DaoImpl implements TutorDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_TUTORS =
            "SELECT id, position, degree, user_id FROM tutor;";

    private static final String SQL_SELECT_TUTOR_BY_ID =
            "SELECT id, position, degree, user_id FROM tutor WHERE id = ?;";

    @Override
    public Integer create(Tutor entity) {
        return BAD_CREATION_CODE;
    }

    @Override
    public List<Tutor> read() throws DAOException {
        List<Tutor> tutors = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_TUTORS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Tutor tutor = new Tutor();
                fillTutor(resultSet, tutor);
                tutors.add(tutor);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return tutors;
    }

    @Override
    public Optional<Tutor> read(Integer id) throws DAOException {
        Tutor tutor = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_TUTOR_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tutor = new Tutor();
                fillTutor(resultSet, tutor);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return Optional.ofNullable(tutor);
    }

    @Override
    public void update(Tutor entity) {
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Tutor entity) {
        return false;
    }

    private void fillTutor(ResultSet resultSet, Tutor tutor) throws SQLException, DAOException {
        tutor.setId(resultSet.getInt(1));
        tutor.setPosition(resultSet.getString(2));
        tutor.setDegree(resultSet.getString(3));
        int userID = resultSet.getInt(4);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(connection);
        User user = userDao.read(userID).orElse(null);
        tutor.setUser(user);
    }
}
