package ft.training.by.dao.mysql;

import ft.training.by.bean.Subject;
import ft.training.by.dao.interfaces.SubjectDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectDaoImpl extends DaoImpl implements SubjectDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_SUBJECTS =
            "SELECT id, name FROM subject;";

    @Override
    public List<Subject> read() throws DAOException {
        List<Subject> subjects = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBJECTS)) {
                    while (resultSet.next()) {
                        Subject subject = new Subject();
                        subject.setId(resultSet.getInt(1));
                        subject.setName(resultSet.getString(2));
                        subjects.add(subject);
                    }
                }
            } finally {
                if (statement != null) {
                }
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return subjects;
    }

    @Override
    public Optional<Subject> read(Integer id) throws DAOException {
        Subject subject = null;
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBJECTS);
                    while (resultSet.next()) {
                        if (resultSet.getInt(1) == id) {
                            subject = new Subject();
                            subject.setId(resultSet.getInt(1));
                            subject.setName(resultSet.getString(2));
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
                }
            }
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        } finally {
        }
        return Optional.ofNullable(subject);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Subject entity) {
        return false;
    }

    @Override
    public boolean create(Subject entity) {
        return false;
    }

    @Override
    public Subject update(Subject entity) {
        return null;
    }
}
