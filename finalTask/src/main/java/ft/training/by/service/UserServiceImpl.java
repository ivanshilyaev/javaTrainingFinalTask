package ft.training.by.service;

import ft.training.by.bean.User;
import ft.training.by.dao.UserDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends ServiceImpl implements UserService {
    @Override
    public List<User> findAll() throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findEntityById(Integer id) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, char[] password) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.findByLoginAndPassword(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User update(User user) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
