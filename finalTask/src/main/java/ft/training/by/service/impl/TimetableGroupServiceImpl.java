package ft.training.by.service.impl;

import ft.training.by.bean.TimetableGroup;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.interfaces.TimetableGroupDao;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TimetableGroupService;

import java.util.List;
import java.util.Optional;

public class TimetableGroupServiceImpl extends ServiceImpl implements TimetableGroupService {
    @Override
    public List<TimetableGroup> read() throws ServiceException {
        try {
            TimetableGroupDao dao = transaction.createDao(TimetableGroupDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<TimetableGroup> read(Integer id) throws ServiceException {
        try {
            TimetableGroupDao dao = transaction.createDao(TimetableGroupDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TimetableGroup> findByTimetableId(Integer timetableId) throws ServiceException {
        try {
            TimetableGroupDao dao = transaction.createDao(TimetableGroupDao.class);
            return dao.findByTimetableId(timetableId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TimetableGroup> findBySubgroupId(Integer subgroupId) throws ServiceException {
        try {
            TimetableGroupDao dao = transaction.createDao(TimetableGroupDao.class);
            return dao.findBySubgroupId(subgroupId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
