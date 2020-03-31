package ft.training.by.service;

import ft.training.by.bean.Group;
import ft.training.by.dao.GroupDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public class GroupServiceImpl extends ServiceImpl implements GroupService {
    @Override
    public List<Group> findAll() throws ServiceException {
        try {
            GroupDao dao = transaction.createDao(GroupDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Group findEntityById(Integer id) throws ServiceException {
        try {
            GroupDao dao = transaction.createDao(GroupDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
