package ft.training.by.dao.interfaces;

import ft.training.by.bean.Performance;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public interface PerformanceDao extends Dao<Integer, Performance> {
    List<Performance> findByStudentId(Integer id) throws DAOException;
}
