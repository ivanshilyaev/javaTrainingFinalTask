package ft.training.by.service.impl;

import ft.training.by.bean.Subject;
import ft.training.by.dao.interfaces.SubjectDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.SubjectService;

import java.util.List;
import java.util.Optional;

public class SubjectServiceImpl extends ServiceImpl implements SubjectService {
    @Override
    public List<Subject> read() throws ServiceException {
        try {
            SubjectDao dao = transaction.createDao(SubjectDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Subject> read(Integer id) throws ServiceException {
        try {
            SubjectDao dao = transaction.createDao(SubjectDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
