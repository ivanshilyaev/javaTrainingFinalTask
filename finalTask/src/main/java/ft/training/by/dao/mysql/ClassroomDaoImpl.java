package ft.training.by.dao.mysql;

import ft.training.by.bean.Classroom;
import ft.training.by.bean.Type;
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
                        classroom.setId(resultSet.getInt(1));
                        classroom.setNumber(resultSet.getString(2));
                        classroom.setCapacity(resultSet.getInt(3));
                        int type = resultSet.getInt(4);
                        switch (type) {
                            case 0:
                                classroom.setType(Type.SEMINAR);
                                break;
                            case 1:
                                classroom.setType(Type.LECTURE);
                                break;
                            default:
                                break;
                        }
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
        return Optional.empty();
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
}
