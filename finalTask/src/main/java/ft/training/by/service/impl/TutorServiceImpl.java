package ft.training.by.service.impl;

import ft.training.by.bean.Tutor;
import ft.training.by.dao.interfaces.TutorDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TutorService;

import java.util.List;
import java.util.Optional;

public class TutorServiceImpl extends ServiceImpl implements TutorService {
    @Override
    public List<Tutor> read() throws ServiceException {
        try {
            TutorDao dao = transaction.createDao(TutorDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Tutor> read(Integer id) throws ServiceException {
        try {
            TutorDao dao = transaction.createDao(TutorDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Tutor> findByUserId(Integer userId) throws ServiceException {
        try {
            TutorDao dao = transaction.createDao(TutorDao.class);
            return dao.findByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
