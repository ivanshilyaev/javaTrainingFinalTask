package ft.training.by.service.interfaces;

import ft.training.by.bean.Tutor;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.Service;

import java.util.List;

public interface TutorService extends Service {
    List<Tutor> findAll() throws ServiceException;
}
