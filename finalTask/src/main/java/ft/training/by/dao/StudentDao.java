package ft.training.by.dao;

import ft.training.by.bean.Student;
import ft.training.by.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends Dao<Integer, Student> {
    // special methods for student
    List<Student> findByGroup(int groupNum) throws DAOException;

    Optional<Student> findByUserId(Integer id) throws DAOException;
}
