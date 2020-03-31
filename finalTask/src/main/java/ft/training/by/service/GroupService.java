package ft.training.by.service;

import ft.training.by.bean.Group;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface GroupService extends Service {
    List<Group> findAll() throws ServiceException;

    Group findEntityById(Integer id) throws ServiceException;
}
