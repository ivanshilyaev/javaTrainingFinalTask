package ft.training.by.service;

import ft.training.by.bean.User;
import ft.training.by.dao.UserDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

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
    public User findEntityById(Integer id) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
