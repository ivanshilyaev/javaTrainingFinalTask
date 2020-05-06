package ft.training.by.service.impl;

import ft.training.by.bean.Classroom;
import ft.training.by.dao.interfaces.ClassroomDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.ClassroomService;

import java.util.List;
import java.util.Optional;

public class ClassroomServiceImpl extends ServiceImpl implements ClassroomService {
    @Override
    public List<Classroom> read() throws ServiceException {
        try {
            ClassroomDao dao = transaction.createDao(ClassroomDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Classroom> read(Integer id) throws ServiceException {
        try {
            ClassroomDao dao = transaction.createDao(ClassroomDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
