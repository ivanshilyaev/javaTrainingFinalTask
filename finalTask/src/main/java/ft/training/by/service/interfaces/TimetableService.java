package ft.training.by.service.interfaces;

import ft.training.by.bean.Timetable;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.Service;

import java.util.List;
import java.util.Optional;

public interface TimetableService extends Service {
    List<Timetable> findAll() throws ServiceException;

    Optional<Timetable> findEntityById(Integer id) throws ServiceException;
}
