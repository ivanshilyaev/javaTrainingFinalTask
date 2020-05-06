package ft.training.by.service.interfaces;

import ft.training.by.bean.Subject;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SubjectService extends Service {
    List<Subject> read() throws ServiceException;

    Optional<Subject> read(Integer id) throws ServiceException;
}
