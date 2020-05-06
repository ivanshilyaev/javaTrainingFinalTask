package ft.training.by.dao.mysql;

import ft.training.by.bean.Classroom;
import ft.training.by.bean.enums.ClassroomType;
import ft.training.by.dao.interfaces.ClassroomDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassroomDaoImpl extends DaoImpl implements ClassroomDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_CLASSROOMS =
            "SELECT id, number, capacity, type, hasProjector FROM classroom;";

    private static final String SQL_SELECT_CLASSROOM_BY_ID =
            "SELECT id, number, capacity, type, hasProjector FROM classroom" +
                    " WHERE id = ?;";

    @Override
    public Integer create(Classroom entity) {
        return BAD_CREATION_CODE;
    }

    @Override
    public List<Classroom> read() throws DAOException {
        List<Classroom> classrooms = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_CLASSROOMS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Classroom classroom = new Classroom();
                fillClassroom(resultSet, classroom);
                classrooms.add(classroom);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return classrooms;
    }

    @Override
    public Optional<Classroom> read(Integer id) throws DAOException {
        Classroom classroom = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLASSROOM_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                classroom = new Classroom();
                fillClassroom(resultSet, classroom);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return Optional.ofNullable(classroom);
    }

    @Override
    public void update(Classroom entity) {
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Classroom entity) {
        return false;
    }

    public void fillClassroom(ResultSet resultSet, Classroom classroom)
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
