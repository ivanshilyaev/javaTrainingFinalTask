package ft.training.by.dao.mysql;

import ft.training.by.bean.Faculty;
import ft.training.by.bean.Group;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.ConnectorDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends AbstractDAO<Integer, Group> {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_GROUPS =
            "SELECT id, group_number, course_number, faculty_id FROM ugroup;";

    @Override
    public List<Group> findAll() throws DAOException {
        List<Group> groups = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_GROUPS);
                    while (resultSet.next()) {
                        Group group = new Group();
                        fillGroup(group, resultSet);
                        groups.add(group);
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
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
            close(connection);
        }
        return groups;
    }

    @Override
    public Group findEntityById(Integer id) throws DAOException {
        Group group = null;
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_GROUPS);
                    while (resultSet.next()) {
                        if (resultSet.getInt(1) == id) {
                            group = new Group();
                            fillGroup(group, resultSet);
                        }
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
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
            close(connection);
        }
        return group;
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

    private void fillGroup(Group group, ResultSet resultSet) throws SQLException, DAOException {
        group.setId(resultSet.getInt(1));
        group.setGroupNumber(resultSet.getInt(2));
        group.setCourseNumber(resultSet.getInt(3));
        int facultyID = resultSet.getInt(4);
        Faculty faculty = new FacultyDAO().findEntityById(facultyID);
        group.setFaculty(faculty);
    }
}
