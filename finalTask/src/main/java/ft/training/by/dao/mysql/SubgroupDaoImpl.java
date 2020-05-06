package ft.training.by.dao.mysql;

import ft.training.by.bean.Group;
import ft.training.by.bean.Subgroup;
import ft.training.by.dao.interfaces.SubgroupDao;
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

public class SubgroupDaoImpl extends DaoImpl implements SubgroupDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_SUBGROUPS =
            "SELECT id, subgroup_number, group_id FROM subgroup;";

    private static final String SQL_SELECT_SUBGROUP_BY_ID =
            "SELECT id, subgroup_number, group_id FROM subgroup WHERE id = ?;";

    private static final String SQL_SELECT_SUBGROUP_BY_NUMBER_AND_GROUP_ID =
            "SELECT id, subgroup_number, group_id FROM subgroup " +
                    "WHERE subgroup_number = ? AND group_id = ?;";

    @Override
    public List<Subgroup> read() throws DAOException {
        List<Subgroup> subgroups = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBGROUPS);
            while (resultSet.next()) {
                Subgroup subgroup = new Subgroup();
                fillSubgroup(resultSet, subgroup);
                subgroups.add(subgroup);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error("DB connection error", e);
        } finally {
        }
        return subgroups;
    }

    @Override
    public Optional<Subgroup> read(Integer id) throws DAOException {
        Subgroup subgroup = null;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_SELECT_SUBGROUP_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                subgroup = new Subgroup();
                fillSubgroup(resultSet, subgroup);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return Optional.ofNullable(subgroup);
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

    @Override
    public Optional<Subgroup> findBySubgroupNumberAndGroupId(char subgroupNum, Integer id) throws DAOException {
        Subgroup subgroup = null;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_SELECT_SUBGROUP_BY_NUMBER_AND_GROUP_ID);
            statement.setString(1, String.valueOf(subgroupNum));
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                subgroup = new Subgroup();
                fillSubgroup(resultSet, subgroup);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return Optional.ofNullable(subgroup);
    }

    private void fillSubgroup(ResultSet resultSet, Subgroup subgroup) throws SQLException, DAOException {
        subgroup.setId(resultSet.getInt(1));
        subgroup.setSubgroupNumber(resultSet.getString(2).charAt(0));
        int groupID = resultSet.getInt(3);
        GroupDaoImpl groupDao = new GroupDaoImpl();
        groupDao.setConnection(connection);
        Group group = groupDao.read(groupID).orElse(null);
        subgroup.setGroup(group);
    }
}
