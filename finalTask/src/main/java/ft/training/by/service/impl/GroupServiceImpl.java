package ft.training.by.service.impl;

import ft.training.by.bean.Group;
import ft.training.by.dao.interfaces.GroupDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.GroupService;

import java.util.List;
import java.util.Optional;

public class GroupServiceImpl extends ServiceImpl implements GroupService {
    @Override
    public List<Group> read() throws ServiceException {
        try {
            GroupDao dao = transaction.createDao(GroupDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Group> read(Integer id) throws ServiceException {
        try {
            GroupDao dao = transaction.createDao(GroupDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Group> findByGroupAndCourse(int groupNum, int courseNum) throws ServiceException {
        try {
            GroupDao dao = transaction.createDao(GroupDao.class);
            return dao.findByGroupAndCourse(groupNum, courseNum);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
