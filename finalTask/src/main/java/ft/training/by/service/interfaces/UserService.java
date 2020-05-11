package ft.training.by.service.interfaces;

import ft.training.by.bean.User;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service {
    Integer create(User entity) throws ServiceException;

    List<User> read() throws ServiceException;

    Optional<User> read(Integer id) throws ServiceException;

    Optional<User> read(String login, char[] password) throws ServiceException;

    void update(User user) throws ServiceException;

    boolean delete(Integer id) throws ServiceException;

    boolean isLoginPresented(String login) throws ServiceException;
}
