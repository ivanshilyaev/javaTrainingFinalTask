package ft.training.by.dao.mysql;

import ft.training.by.bean.Faculty;
import ft.training.by.dao.interfaces.FacultyDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacultyDaoImpl extends DaoImpl implements FacultyDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_FACULTIES =
            "SELECT id, name FROM faculty;";

    private static final String SQL_SELECT_FACULTIY_BY_ID =
            "SELECT id, name FROM faculty WHERE id = ?;";

    @Override
    public Integer create(Faculty entity) {
        return BAD_CREATION_CODE;
    }

    @Override
    public List<Faculty> read() throws DAOException {
        List<Faculty> faculties = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_FACULTIES)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Faculty faculty = new Faculty();
                fillFaculty(resultSet, faculty);
                faculties.add(faculty);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return faculties;
    }

    @Override
    public Optional<Faculty> read(Integer id) {
        Faculty faculty = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FACULTIY_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                faculty = new Faculty();
                fillFaculty(resultSet, faculty);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(faculty);
    }

    @Override
    public void update(Faculty entity) {
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Faculty entity) {
        return false;
    }

    private void fillFaculty(ResultSet resultSet, Faculty faculty) throws SQLException {
        faculty.setId(resultSet.getInt(1));
        faculty.setName(resultSet.getString(2));
    }
}
