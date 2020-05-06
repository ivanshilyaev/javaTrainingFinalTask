package ft.training.by.service.impl;

import ft.training.by.bean.Faculty;
import ft.training.by.dao.interfaces.FacultyDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class FacultyServiceImpl extends ServiceImpl implements FacultyService {
    @Override
    public List<Faculty> read() throws ServiceException {
        try {
            FacultyDao dao = transaction.createDao(FacultyDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Faculty> read(Integer id) throws ServiceException {
        try {
            FacultyDao dao = transaction.createDao(FacultyDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
