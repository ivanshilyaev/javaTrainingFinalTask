package ft.training.by.service.impl;

import ft.training.by.bean.Timetable;
import ft.training.by.dao.interfaces.TimetableDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TimetableService;

import java.util.List;

public class TimetableServiceImpl extends ServiceImpl implements TimetableService {
    @Override
    public List<Timetable> findAll() throws ServiceException {
        try {
            TimetableDao dao = transaction.createDao(TimetableDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
