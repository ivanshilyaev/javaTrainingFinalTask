package ft.training.by.service;

import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface StudentService extends Service {
    List<Student> findAll() throws ServiceException;

    Student findEntityById(Integer id) throws ServiceException;
}
