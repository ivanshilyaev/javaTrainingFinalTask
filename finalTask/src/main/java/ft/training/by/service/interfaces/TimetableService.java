package ft.training.by.service.interfaces;

import ft.training.by.bean.Timetable;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface TimetableService extends Service {
    List<Timetable> read() throws ServiceException;

    Optional<Timetable> read(Integer id) throws ServiceException;

    List<Timetable> findByTutorId(Integer tutorId) throws ServiceException;
}
