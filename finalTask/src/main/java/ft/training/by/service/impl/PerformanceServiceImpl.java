package ft.training.by.service.impl;

import ft.training.by.bean.Performance;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.interfaces.PerformanceDao;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.PerformanceService;

import java.util.List;
import java.util.Optional;

public class PerformanceServiceImpl extends ServiceImpl implements PerformanceService {
    @Override
    public List<Performance> read() throws ServiceException {
        try {
            PerformanceDao dao = transaction.createDao(PerformanceDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Performance> read(Integer id) throws ServiceException {
        try {
            PerformanceDao dao = transaction.createDao(PerformanceDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Performance> findByStudentId(Integer id) throws ServiceException {
        try {
            PerformanceDao dao = transaction.createDao(PerformanceDao.class);
            return dao.findByStudentId(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
