package ft.training.by.service;

import ft.training.by.bean.Subject;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface SubjectService extends Service {
    List<Subject> findAll() throws ServiceException;
}
