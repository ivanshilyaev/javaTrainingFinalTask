package ft.training.by.service;

import ft.training.by.bean.Classroom;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface ClassroomService extends Service {
    List<Classroom> findAll() throws ServiceException;
}
