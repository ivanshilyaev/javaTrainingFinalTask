package ft.training.by.service.interfaces;

import ft.training.by.bean.Tutor;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface TutorService extends Service {
    Integer create(Tutor entity) throws ServiceException;

    List<Tutor> read() throws ServiceException;

    Optional<Tutor> read(Integer id) throws ServiceException;

    Optional<Tutor> findByUserId(Integer userId) throws ServiceException;
}
