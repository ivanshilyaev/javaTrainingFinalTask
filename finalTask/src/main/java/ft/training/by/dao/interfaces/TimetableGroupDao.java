package ft.training.by.dao.interfaces;

import ft.training.by.bean.TimetableGroup;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public interface TimetableGroupDao extends Dao<Integer, TimetableGroup> {
    List<TimetableGroup> findByTimetableId(Integer timetableId) throws DAOException;

    List<TimetableGroup> findBySubgroupId(Integer subgroupId) throws DAOException;
}
