package ft.training.by.service.interfaces;

import ft.training.by.bean.Faculty;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface FacultyService extends Service {
    List<Faculty> findAll() throws ServiceException;

    Optional<Faculty> findEntityById(Integer id) throws ServiceException;
}
