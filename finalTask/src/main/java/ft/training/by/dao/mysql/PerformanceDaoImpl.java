package ft.training.by.dao.mysql;

import ft.training.by.bean.*;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.interfaces.PerformanceDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PerformanceDaoImpl extends DaoImpl implements PerformanceDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_PERFORMANCE =
            "SELECT id, student_id, subject_id, semester, credit, exam FROM performance;";

    private static final String SQL_SELECT_PERFORMANCE_BY_ID =
            "SELECT id, student_id, subject_id, semester, credit, exam FROM performance WHERE id = ?;";

    private static final String SQL_SELECT_PERFORMANCE_BY_STUDENT_ID =
            "SELECT id, student_id, subject_id, semester, credit, exam FROM performance WHERE student_id = ?;";

    @Override
    public Integer create(Performance entity) throws DAOException {
        return null;
    }

    @Override
    public List<Performance> read() throws DAOException {
        List<Performance> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_PERFORMANCE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Performance performance = new Performance();
                fillPerformance(resultSet, performance);
                list.add(performance);
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return list;
    }

    @Override
    public Optional<Performance> read(Integer id) throws DAOException {
        Performance performance = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PERFORMANCE_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                performance = new Performance();
                fillPerformance(resultSet, performance);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(performance);
    }

    @Override
    public void update(Performance entity) {

    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        return false;
    }

    private void fillPerformance(ResultSet resultSet, Performance performance) throws SQLException, DAOException {
        performance.setId(resultSet.getInt(1));
        int studentID = resultSet.getInt(2);
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setConnection(connection);
        Student student = studentDao.read(studentID).orElse(null);
        performance.setStudent(student);
        int subjectID = resultSet.getInt(3);
        SubjectDaoImpl subjectDao = new SubjectDaoImpl();
        subjectDao.setConnection(connection);
        Subject subject = subjectDao.read(subjectID).orElse(null);
        performance.setSubject(subject);
        performance.setSemester(resultSet.getInt(4));
        performance.setCredit(resultSet.getString(5));
        performance.setExam(resultSet.getString(6));
    }

    @Override
    public List<Performance> findByStudentId(Integer id) throws DAOException {
        List<Performance> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PERFORMANCE_BY_STUDENT_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Performance performance = new Performance();
                fillPerformance(resultSet, performance);
                list.add(performance);
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return list;
    }
}
