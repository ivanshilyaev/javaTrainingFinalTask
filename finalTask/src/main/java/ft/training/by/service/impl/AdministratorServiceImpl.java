package ft.training.by.service.impl;

import ft.training.by.bean.Administrator;
import ft.training.by.dao.interfaces.AdministratorDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.AdministratorService;

import java.util.List;
import java.util.Optional;

public class AdministratorServiceImpl extends ServiceImpl implements AdministratorService {
    @Override
    public List<Administrator> read() throws ServiceException {
        try {
            AdministratorDao dao = transaction.createDao(AdministratorDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Administrator> read(Integer id) throws ServiceException {
        try {
            AdministratorDao dao = transaction.createDao(AdministratorDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
