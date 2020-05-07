package ft.training.by.dao.interfaces;

import ft.training.by.bean.Group;
import ft.training.by.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface GroupDao extends Dao<Integer, Group> {
    List<Group> findByFacultyId(Integer id) throws DAOException;

    Optional<Group> findByGroupCourseFaculty(int groupNum, int courseNum, int facultyId) throws DAOException;
}
