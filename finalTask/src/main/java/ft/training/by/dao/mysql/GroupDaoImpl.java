package ft.training.by.dao.mysql;

import ft.training.by.bean.Faculty;
import ft.training.by.bean.Group;
import ft.training.by.dao.interfaces.GroupDao;
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

public class GroupDaoImpl extends DaoImpl implements GroupDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_GROUPS =
            "SELECT id, group_number, course_number, faculty_id FROM ugroup;";

    public static final String SQL_SELECT_GROUP_BY_ID =
            "SELECT id, group_number, course_number, faculty_id FROM ugroup" +
                    " WHERE id = ?;";

    @Override
    public List<Group> read() throws DAOException {
        List<Group> groups = new ArrayList<>();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_GROUPS);
            while (resultSet.next()) {
                Group group = new Group();
                fillGroup(group, resultSet);
                groups.add(group);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        } finally {
        }
        return groups;
    }

    @Override
    public Optional<Group> read(Integer id) throws DAOException {
        Group group = null;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_SELECT_GROUP_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                group = new Group();
                fillGroup(group, resultSet);
                resultSet.close();
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return Optional.ofNullable(group);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Group entity) {
        return false;
    }

    @Override
    public boolean create(Group entity) {
        return false;
    }

    @Override
    public Group update(Group entity) {
        return null;
    }

    private void fillGroup(Group group, ResultSet resultSet) throws SQLException {
        group.setId(resultSet.getInt(1));
        group.setGroupNumber(resultSet.getInt(2));
        group.setCourseNumber(resultSet.getInt(3));
        int facultyID = resultSet.getInt(4);
        FacultyDaoImpl facultyDao = new FacultyDaoImpl();
        facultyDao.setConnection(connection);
        Faculty faculty = facultyDao.read(facultyID).orElse(null);
        group.setFaculty(faculty);
    }
}
