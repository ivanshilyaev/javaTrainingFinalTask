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
    public Integer create(TimetableGroup entity) {
        return BAD_CREATION_CODE;
    }

    @Override
    public List<TimetableGroup> read() throws DAOException {
        List<TimetableGroup> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_ITEMS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TimetableGroup timetableGroup = new TimetableGroup();
                fillTimetableGroup(resultSet, timetableGroup);
                list.add(timetableGroup);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return list;
    }

    @Override
    public Optional<TimetableGroup> read(Integer id) throws DAOException {
        TimetableGroup timetableGroup = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ITEM_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                timetableGroup = new TimetableGroup();
                fillTimetableGroup(resultSet, timetableGroup);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return Optional.ofNullable(timetableGroup);
    }

    @Override
    public void update(TimetableGroup entity) {
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<TimetableGroup> findBySubgroupId(Integer id) throws DAOException {
        List<TimetableGroup> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ITEM_BY_SUBGROUP_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TimetableGroup timetableGroup = new TimetableGroup();
                fillTimetableGroup(resultSet, timetableGroup);
                list.add(timetableGroup);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            LOGGER.error("DB connection error", throwables);
        }
        return list;
    }

    private void fillTimetableGroup(ResultSet resultSet, TimetableGroup timetableGroup)
            throws SQLException, DAOException {
        timetableGroup.setId(resultSet.getInt(1));
        int timetableId = resultSet.getInt(2);
        TimetableDaoImpl timetableDao = new TimetableDaoImpl();
        timetableDao.setConnection(connection);
        Timetable timetable = timetableDao.read(timetableId).orElse(null);
        timetableGroup.setTimetable(timetable);
        int subgroupId = resultSet.getInt(3);
        SubgroupDaoImpl subgroupDao = new SubgroupDaoImpl();
        subgroupDao.setConnection(connection);
        Subgroup subgroup = subgroupDao.read(subgroupId).orElse(null);
        timetableGroup.setSubgroup(subgroup);
    }
}
