package ft.training.by.dao.mysql;

import ft.training.by.bean.Classroom;
import ft.training.by.bean.enums.ClassroomType;
import ft.training.by.dao.ClassroomDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassroomDaoImpl extends DaoImpl implements ClassroomDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_CLASSROOMS =
            "SELECT id, number, capacity, type, hasProjector FROM classroom;";

    @Override
    public List<Classroom> findAll() throws DAOException {
        List<Classroom> classrooms = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CLASSROOMS)) {
                    while (resultSet.next()) {
                        Classroom classroom = new Classroom();
                        fillClassroom(classroom, resultSet);
                        classrooms.add(classroom);
                    }
                }
            } finally {
                if (statement != null) {
                    close(statement);
                }
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
            closeConnection();
        }
        return classrooms;
    }

    @Override
    public Optional<Classroom> findEntityById(Integer id) throws DAOException {
        Classroom classroom = null;
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_CLASSROOMS);
                    while (resultSet.next()) {
                        if (resultSet.getInt(1) == id) {
                            classroom = new Classroom();
                            fillClassroom(classroom, resultSet);
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
        return Optional.ofNullable(classroom);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Classroom entity) {
        return false;
    }

    @Override
    public boolean create(Classroom entity) {
        return false;
    }

    @Override
    public Classroom update(Classroom entity) {
        return null;
    }

    public void fillClassroom(Classroom classroom, ResultSet resultSet)
            throws SQLException {
        classroom.setId(resultSet.getInt(1));
        classroom.setNumber(resultSet.getString(2));
        classroom.setCapacity(resultSet.getInt(3));
        classroom.setClassroomType(ClassroomType.getById(resultSet.getInt(4)));
        int hasProjector = resultSet.getInt(5);
        switch (hasProjector) {
            case 0:
                classroom.setHasProjector(false);
                break;
            case 1:
                classroom.setHasProjector(true);
                break;
            default:
                break;
        }
    }
}
