package ft.training.by.dao.mysql;

import ft.training.by.bean.Subject;
import ft.training.by.dao.interfaces.SubjectDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectDaoImpl extends DaoImpl implements SubjectDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_SUBJECTS =
            "SELECT id, name FROM subject;";

    private static final String SQL_SELECT_SUBJECT_BY_ID =
            "SELECT id, name FROM subject WHERE id = ?;";

    @Override
    public Integer create(Subject entity) {
        return BAD_CREATION_CODE;
    }

    @Override
    public List<Subject> read() throws DAOException {
        List<Subject> subjects = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_SUBJECTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Subject subject = new Subject();
                fillSubject(resultSet, subject);
                subjects.add(subject);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return subjects;
    }

    @Override
    public Optional<Subject> read(Integer id) throws DAOException {
        Subject subject = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_SUBJECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subject = new Subject();
                fillSubject(resultSet, subject);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return Optional.ofNullable(subject);
    }

    @Override
    public void update(Subject entity) {
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    private void fillSubject(ResultSet resultSet, Subject subject) throws SQLException {
        subject.setId(resultSet.getInt(1));
        subject.setName(resultSet.getString(2));
    }
}
