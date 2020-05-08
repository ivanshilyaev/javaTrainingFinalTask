package ft.training.by.dao.interfaces;

import ft.training.by.bean.Group;
import ft.training.by.dao.exception.DAOException;

import java.util.Optional;

public interface GroupDao extends Dao<Integer, Group> {
    Optional<Group> findByGroupAndCourse(int groupNum, int courseNum) throws DAOException;
}
