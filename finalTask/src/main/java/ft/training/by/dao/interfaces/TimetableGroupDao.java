package ft.training.by.dao.interfaces;

import ft.training.by.bean.TimetableGroup;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public interface TimetableGroupDao extends Dao<Integer, TimetableGroup> {
    List<TimetableGroup> findBySubgroupId(Integer id) throws DAOException;
}
