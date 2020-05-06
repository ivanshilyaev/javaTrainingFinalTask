package ft.training.by.dao.mysql;

import ft.training.by.bean.Subgroup;
import ft.training.by.bean.Timetable;
import ft.training.by.bean.TimetableGroup;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.interfaces.TimetableGroupDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TimetableGroupDaoImpl extends DaoImpl implements TimetableGroupDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SQL_SELECT_ALL_ITEMS =
            "SELECT id, timetable_id, subgroup_id FROM timetable_group;";

    private static final String SQL_SELECT_ITEM_BY_ID =
            "SELECT id, timetable_id, subgroup_id FROM timetable_group" +
                    " WHERE id = ?;";

    public static final String SQL_SELECT_ITEM_BY_SUBGROUP_ID =
            "SELECT id, timetable_id, subgroup_id FROM timetable_group" +
                    " WHERE subgroup_id = ?;";

    @Override
    public List<TimetableGroup> findAll() throws DAOException {
        List<TimetableGroup> list = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ITEMS);
            while (resultSet.next()) {
                TimetableGroup timetableGroup = new TimetableGroup();
                fillTimetableGroup(resultSet, timetableGroup);
                list.add(timetableGroup);
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return list;
    }

    @Override
    public Optional<TimetableGroup> findEntityById(Integer id) throws DAOException {
        TimetableGroup timetableGroup = null;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ITEM_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                timetableGroup = new TimetableGroup();
                fillTimetableGroup(resultSet, timetableGroup);
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return Optional.ofNullable(timetableGroup);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(TimetableGroup entity) {
        return false;
    }

    @Override
    public boolean create(TimetableGroup entity) {
        return false;
    }

    @Override
    public TimetableGroup update(TimetableGroup entity) {
        return null;
    }

    @Override
    public List<TimetableGroup> findBySubgroupId(Integer id) throws DAOException {
        List<TimetableGroup> list = new ArrayList<>();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ITEM_BY_SUBGROUP_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TimetableGroup timetableGroup = new TimetableGroup();
                fillTimetableGroup(resultSet, timetableGroup);
                list.add(timetableGroup);
            }
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        } finally {
        }
        return list;
    }

    private void fillTimetableGroup(ResultSet resultSet, TimetableGroup timetableGroup)
            throws SQLException, DAOException {
        timetableGroup.setId(resultSet.getInt(1));
        int timetableId = resultSet.getInt(2);
        TimetableDaoImpl timetableDao = new TimetableDaoImpl();
        timetableDao.setConnection(connection);
        Timetable timetable = timetableDao.findEntityById(timetableId).orElse(null);
        timetableGroup.setTimetable(timetable);
        int subgroupId = resultSet.getInt(3);
        SubgroupDaoImpl subgroupDao = new SubgroupDaoImpl();
        subgroupDao.setConnection(connection);
        Subgroup subgroup = subgroupDao.findEntityById(subgroupId).orElse(null);
        timetableGroup.setSubgroup(subgroup);
    }
}
