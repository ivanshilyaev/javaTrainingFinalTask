package ft.training.by.service.interfaces;

import ft.training.by.bean.Faculty;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface FacultyService extends Service {
    List<Faculty> read() throws ServiceException;

    Optional<Faculty> read(Integer id) throws ServiceException;
}
