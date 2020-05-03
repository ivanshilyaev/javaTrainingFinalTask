package ft.training.by.service.impl;

import ft.training.by.bean.TimetableGroup;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.interfaces.TimetableGroupDao;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TimetableGroupService;

import java.util.List;

public class TimetableGroupServiceImpl extends ServiceImpl implements TimetableGroupService {
    @Override
    public List<TimetableGroup> findAll() throws ServiceException {
        try {
            TimetableGroupDao dao = transaction.createDao(TimetableGroupDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
