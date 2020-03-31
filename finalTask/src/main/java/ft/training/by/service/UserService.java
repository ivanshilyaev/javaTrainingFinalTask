package ft.training.by.service;

import ft.training.by.bean.User;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface UserService extends Service {
    List<User> findAll() throws ServiceException;

    User findEntityById(Integer id) throws ServiceException;
}
