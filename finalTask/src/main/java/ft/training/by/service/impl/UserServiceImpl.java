package ft.training.by.service.impl;

import ft.training.by.bean.User;
import ft.training.by.dao.interfaces.UserDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends ServiceImpl implements UserService {
    @Override
    public Integer create(User entity) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.create(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> read() throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> read(Integer id) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> read(String login, char[] password) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.read(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(User user) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            dao.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
