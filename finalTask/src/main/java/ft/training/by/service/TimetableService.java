package ft.training.by.service;

import ft.training.by.bean.Timetable;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface TimetableService extends Service {
    List<Timetable> findAll() throws ServiceException;
}
