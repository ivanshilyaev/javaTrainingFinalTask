package ft.training.by.service;

import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface StudentService extends Service {
    List<Student> findAll() throws ServiceException;

    Optional<Student> findEntityById(Integer id) throws ServiceException;
}
