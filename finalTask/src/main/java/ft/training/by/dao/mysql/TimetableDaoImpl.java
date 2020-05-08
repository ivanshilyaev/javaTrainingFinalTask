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

    @Override
    public Integer create(Timetable entity) {
        return BAD_CREATION_CODE;
    }

    public List<Timetable> read() throws DAOException {
        List<Timetable> timetables = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_CLASSES)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Timetable timetable = new Timetable();
                fillTimetable(resultSet, timetable);
                timetables.add(timetable);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return timetables;
    }

    @Override
    public Optional<Timetable> read(Integer id) throws DAOException {
        Timetable timetable = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLASS_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                timetable = new Timetable();
                fillTimetable(resultSet, timetable);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(timetable);
    }

    @Override
    public void update(Timetable entity) {
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public void fillTimetable(ResultSet resultSet, Timetable timetable)
            throws SQLException, DAOException {
        timetable.setId(resultSet.getInt(1));
        timetable.setDay(Day.getById(resultSet.getInt(2)));
        timetable.setPairNumber(resultSet.getInt(3));
        int subjectId = resultSet.getInt(4);
        SubjectDaoImpl subjectDao = new SubjectDaoImpl();
        subjectDao.setConnection(connection);
        Subject subject = subjectDao.read(subjectId).orElse(null);
        timetable.setSubject(subject);
        timetable.setClassType(ClassType.getById(resultSet.getInt(5)));
        int classroomId = resultSet.getInt(6);
        ClassroomDaoImpl classroomDao = new ClassroomDaoImpl();
        classroomDao.setConnection(connection);
        Classroom classroom = classroomDao.read(classroomId).orElse(null);
        timetable.setClassroom(classroom);
        int tutorId = resultSet.getInt(7);
        TutorDaoImpl tutorDao = new TutorDaoImpl();
        tutorDao.setConnection(connection);
        Tutor tutor = tutorDao.read(tutorId).orElse(null);
        timetable.setTutor(tutor);
    }
}
