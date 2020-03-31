package ft.training.by.dao.mysql;

import ft.training.by.bean.Faculty;
import ft.training.by.dao.FacultyDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacultyDaoImpl extends DaoImpl implements FacultyDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_FACULTIES =
            "SELECT id, name FROM faculty;";

    @Override
    public List<Faculty> findAll() throws DAOException {
        List<Faculty> faculties = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_FACULTIES);
                    while (resultSet.next()) {
                        Faculty faculty = new Faculty();
                        fillFaculty(resultSet, faculty);
                        faculties.add(faculty);
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
        return faculties;
    }

    @Override
    public Faculty findEntityById(Integer id) {
        Faculty faculty = null;
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_FACULTIES);
            while (resultSet.next()) {
                if (resultSet.getInt(1) == id) {
                    faculty = new Faculty();
                    fillFaculty(resultSet, faculty);
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("Couldn't create statement", e);
        } finally {
            if (statement != null) {
                close(statement);
            }
        }
        return faculty;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Faculty entity) {
        return false;
    }

    @Override
    public boolean create(Faculty entity) {
        return false;
    }

    @Override
    public Faculty update(Faculty entity) {
        return null;
    }

    private void fillFaculty(ResultSet resultSet, Faculty faculty) throws SQLException {
        faculty.setId(resultSet.getInt(1));
        faculty.setName(resultSet.getString(2));
    }
}
