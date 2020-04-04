package ft.training.by.service;

import ft.training.by.bean.Group;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GroupService extends Service {
    List<Group> findAll() throws ServiceException;

    Optional<Group> findEntityById(Integer id) throws ServiceException;
}
