package ft.training.by.service;

import ft.training.by.bean.Tutor;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface TutorService extends Service {
    List<Tutor> findAll() throws ServiceException;
}
