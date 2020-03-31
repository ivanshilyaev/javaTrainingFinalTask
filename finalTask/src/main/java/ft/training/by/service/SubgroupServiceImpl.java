package ft.training.by.service;

import ft.training.by.bean.Subgroup;
import ft.training.by.dao.SubgroupDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public class SubgroupServiceImpl extends ServiceImpl implements SubgroupService {
    @Override
    public List<Subgroup> findAll() throws ServiceException {
        try {
            SubgroupDao dao = transaction.createDao(SubgroupDao.class);
            return dao.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Subgroup findEntityById(Integer id) throws ServiceException {
        try {
            SubgroupDao dao = transaction.createDao(SubgroupDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
