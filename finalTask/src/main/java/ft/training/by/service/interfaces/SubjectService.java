package ft.training.by.service.interfaces;

import ft.training.by.bean.Subject;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.Service;

import java.util.List;

public interface SubjectService extends Service {
    List<Subject> findAll() throws ServiceException;
}
