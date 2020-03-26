package ft.training.by.dao.mysql;

import ft.training.by.bean.Group;
import ft.training.by.bean.Subgroup;
import ft.training.by.dao.SubgroupDao;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubgroupDaoImpl extends DaoImpl implements SubgroupDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_SUBGROUPS =
            "SELECT id, subgroup_number, group_id FROM subgroup;";

    @Override
    public List<Subgroup> findAll() throws DAOException {
        List<Subgroup> subgroups = new ArrayList<>();
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBGROUPS);
                    while (resultSet.next()) {
                        Subgroup subgroup = new Subgroup();
                        fillSubgroup(resultSet, subgroup);
                        subgroups.add(subgroup);
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
            closeConnection();
        }
        return subgroups;
    }

    @Override
    public Subgroup findEntityById(Integer id) throws DAOException {
        Subgroup subgroup = null;
        try {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBGROUPS);
                    while (resultSet.next()) {
                        if (resultSet.getInt(1) == id) {
                            subgroup = new Subgroup();
                            fillSubgroup(resultSet, subgroup);
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
            closeConnection();
        }
        return subgroup;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Subgroup entity) {
        return false;
    }

    @Override
    public boolean create(Subgroup entity) {
        return false;
    }

    @Override
    public Subgroup update(Subgroup entity) {
        return null;
    }

    private void fillSubgroup(ResultSet resultSet, Subgroup subgroup) throws SQLException, DAOException {
        subgroup.setId(resultSet.getInt(1));
        subgroup.setSubgroupNumber(resultSet.getString(2).charAt(0));
        int groupID = resultSet.getInt(3);
        GroupDaoImpl groupDao = new GroupDaoImpl();
        groupDao.setConnection(connection);
        Group group = groupDao.findEntityById(groupID);
        subgroup.setGroup(group);
    }
}
