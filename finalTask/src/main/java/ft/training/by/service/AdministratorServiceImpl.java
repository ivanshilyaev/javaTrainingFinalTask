package ft.training.by.service;

import ft.training.by.bean.Administrator;
import ft.training.by.dao.AdministratorDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public class AdministratorServiceImpl extends ServiceImpl implements AdministratorService {
    @Override
    public List<Administrator> findAll() throws ServiceException {
        try {
            AdministratorDao dao = transaction.createDao(AdministratorDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
