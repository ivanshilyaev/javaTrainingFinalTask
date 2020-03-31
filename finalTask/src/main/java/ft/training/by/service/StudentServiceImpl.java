package ft.training.by.service;

import ft.training.by.bean.Student;
import ft.training.by.dao.StudentDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public class StudentServiceImpl extends ServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Student findEntityById(Integer id) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
