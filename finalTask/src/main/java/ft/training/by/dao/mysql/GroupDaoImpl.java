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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupDaoImpl extends DaoImpl implements GroupDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_GROUPS =
            "SELECT id, group_number, course_number, faculty_id FROM ugroup;";

    private static final String SQL_SELECT_GROUP_BY_ID =
            "SELECT id, group_number, course_number, faculty_id FROM ugroup" +
                    " WHERE id = ?;";

    private static final String SQL_SELECT_GROUP_BY_FACULTY_ID =
            "SELECT id, group_number, course_number, faculty_id FROM ugroup" +
                    " WHERE faculty_id = ?;";

    @Override
    public Integer create(Group entity) {
        return BAD_CREATION_CODE;
    }

    @Override
    public List<Group> read() throws DAOException {
        List<Group> groups = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_GROUPS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                fillGroup(resultSet, group);
                groups.add(group);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        }
        return groups;
    }

    @Override
    public Optional<Group> read(Integer id) throws DAOException {
        Group group = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_GROUP_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                group = new Group();
                fillGroup(resultSet, group);
                resultSet.close();
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(group);
    }

    @Override
    public void update(Group entity) {
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
    public List<Group> findByFacultyId(Integer id) throws DAOException {
        List<Group> groups = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_GROUP_BY_FACULTY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                fillGroup(resultSet, group);
                groups.add(group);
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return groups;
    }

    @Override
    public Optional<Group> findByGroupCourseFaculty(int groupNum, int courseNum, int facultyId) throws DAOException {
        List<Group> groups = findByFacultyId(facultyId);
        groups.removeIf(group -> group.getGroupNumber() != groupNum ||
                group.getCourseNumber() != courseNum);
        return Optional.ofNullable(groups.get(0));
    }

    private void fillGroup(ResultSet resultSet, Group group) throws SQLException {
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
