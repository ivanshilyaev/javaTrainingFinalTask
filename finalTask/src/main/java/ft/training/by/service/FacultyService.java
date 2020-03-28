package ft.training.by.service;

import ft.training.by.bean.Faculty;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface FacultyService extends Service {
    List<Faculty> findAll() throws ServiceException;

    Faculty findEntityById(Integer id) throws ServiceException;
}
