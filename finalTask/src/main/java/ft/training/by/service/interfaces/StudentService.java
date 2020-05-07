package ft.training.by.service.interfaces;

import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface StudentService extends Service {
    Integer create(Student entity) throws ServiceException;

    List<Student> read() throws ServiceException;

    Optional<Student> read(Integer id) throws ServiceException;

    boolean delete(Integer id) throws ServiceException;

    boolean delete(Student entity) throws ServiceException;

    List<Student> findByGroupAndCourse(int groupNum, int courseNum) throws ServiceException;

    Optional<Student> findByUserId(Integer userId) throws ServiceException;
}
