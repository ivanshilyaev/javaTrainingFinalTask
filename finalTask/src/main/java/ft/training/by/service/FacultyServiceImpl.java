package ft.training.by.service;

import ft.training.by.bean.Faculty;
import ft.training.by.dao.FacultyDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FacultyServiceImpl extends ServiceImpl implements FacultyService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Faculty> findAll() throws ServiceException {
        try {
            FacultyDao dao = transaction.createDao(FacultyDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Faculty findEntityById(Integer id) throws ServiceException {
        try {
            FacultyDao dao = transaction.createDao(FacultyDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
