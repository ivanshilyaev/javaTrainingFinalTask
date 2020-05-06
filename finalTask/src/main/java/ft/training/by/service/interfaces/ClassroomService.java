package ft.training.by.service.interfaces;

import ft.training.by.bean.Classroom;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface ClassroomService extends Service {
    List<Classroom> read() throws ServiceException;

    Optional<Classroom> read(Integer id) throws ServiceException;
}
