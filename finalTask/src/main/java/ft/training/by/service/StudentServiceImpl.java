package ft.training.by.service;

import ft.training.by.bean.Student;
import ft.training.by.dao.StudentDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

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
    public Optional<Student> findEntityById(Integer id) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Student> findByGroup(int groupNum) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findByGroup(groupNum);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Student> findByUserId(Integer id) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findByUserId(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
