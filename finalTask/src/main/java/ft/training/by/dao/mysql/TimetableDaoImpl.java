package ft.training.by.dao.mysql;

import ft.training.by.bean.Classroom;
import ft.training.by.bean.Subject;
import ft.training.by.bean.Timetable;
import ft.training.by.bean.Tutor;
import ft.training.by.bean.enums.ClassType;
import ft.training.by.bean.enums.Day;
import ft.training.by.dao.interfaces.TimetableDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TimetableDaoImpl extends DaoImpl implements TimetableDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_CLASSES =
            "SELECT id, day, pair_number, subject_id, type" +
                    ", classroom_id, tutor_id FROM timetable;";

    private static final String SQL_SELECT_CLASS_BY_ID =
            "SELECT id, day, pair_number, subject_id, type" +
                    ", classroom_id, tutor_id FROM timetable" +
                    " WHERE id = ?;";

    public List<Timetable> findAll() throws DAOException {
        List<Timetable> timetables = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CLASSES)) {
                    while (resultSet.next()) {
                        Timetable timetable = new Timetable();
                        fillTimetable(timetable, resultSet);
                        timetables.add(timetable);
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
        return timetables;
    }

    @Override
    public Optional<Timetable> findEntityById(Integer id) throws DAOException {
        Timetable timetable = null;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_SELECT_CLASS_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                timetable = new Timetable();
                fillTimetable(timetable, resultSet);
                resultSet.close();
                close(statement);
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(timetable);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Timetable entity) {
        return false;
    }

    @Override
    public boolean create(Timetable entity) {
        return false;
    }

    @Override
    public Timetable update(Timetable entity) {
        return null;
    }

    public void fillTimetable(Timetable timetable, ResultSet resultSet)
            throws SQLException, DAOException {
        timetable.setId(resultSet.getInt(1));
        timetable.setDay(Day.getById(resultSet.getInt(2)));
        timetable.setPairNumber(resultSet.getInt(3));
        int subjectId = resultSet.getInt(4);
        SubjectDaoImpl subjectDao = new SubjectDaoImpl();
        subjectDao.setConnection(connection);
        Subject subject = subjectDao.findEntityById(subjectId).orElse(null);
        timetable.setSubject(subject);
        timetable.setClassType(ClassType.getById(resultSet.getInt(5)));
        int classroomId = resultSet.getInt(6);
        ClassroomDaoImpl classroomDao = new ClassroomDaoImpl();
        classroomDao.setConnection(connection);
        Classroom classroom = classroomDao.findEntityById(classroomId).orElse(null);
        timetable.setClassroom(classroom);
        int tutorId = resultSet.getInt(7);
        TutorDaoImpl tutorDao = new TutorDaoImpl();
        tutorDao.setConnection(connection);
        Tutor tutor = tutorDao.findEntityById(tutorId).orElse(null);
        timetable.setTutor(tutor);
    }
}
