package ft.training.by.dao.interfaces;

import ft.training.by.bean.Student;
import ft.training.by.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends Dao<Integer, Student> {
    List<Student> findByGroupAndCourse(int groupNum, int courseNum) throws DAOException;

    Optional<Student> findByUserId(Integer id) throws DAOException;

    List<Student> findBySubgroupId(Integer id) throws DAOException;
}
