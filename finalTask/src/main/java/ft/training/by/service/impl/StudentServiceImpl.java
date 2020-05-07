package ft.training.by.service.impl;

import ft.training.by.bean.Student;
import ft.training.by.dao.interfaces.StudentDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl extends ServiceImpl implements StudentService {
    @Override
    public Integer create(Student entity) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.create(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Student> read() throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Student> read(Integer id) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Student entity) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.delete(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Student> findByGroupCourseFaculty(int groupNum, int courseNum) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findByGroupAndCourse(groupNum, courseNum);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Student> findByUserId(Integer userId) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Student> findBySubgroupId(Integer id) throws ServiceException {
        try {
            StudentDao dao = transaction.createDao(StudentDao.class);
            return dao.findBySubgroupId(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
