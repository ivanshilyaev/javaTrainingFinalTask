package ft.training.by.service.impl;

import ft.training.by.bean.Tutor;
import ft.training.by.dao.interfaces.TutorDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TutorService;

import java.util.List;

public class TutorServiceImpl extends ServiceImpl implements TutorService {
    @Override
    public List<Tutor> findAll() throws ServiceException {
        try {
            TutorDao dao = transaction.createDao(TutorDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
