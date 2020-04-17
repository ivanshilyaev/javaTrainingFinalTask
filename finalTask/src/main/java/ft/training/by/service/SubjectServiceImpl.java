package ft.training.by.service;

import ft.training.by.bean.Subject;
import ft.training.by.dao.SubjectDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public class SubjectServiceImpl extends ServiceImpl implements SubjectService {
    @Override
    public List<Subject> findAll() throws ServiceException {
        try {
            SubjectDao dao = transaction.createDao(SubjectDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
