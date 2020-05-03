package ft.training.by.service.impl;

import ft.training.by.bean.Subgroup;
import ft.training.by.dao.interfaces.SubgroupDao;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.SubgroupService;

import java.util.List;
import java.util.Optional;

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
    public Optional<Subgroup> findEntityById(Integer id) throws ServiceException {
        try {
            SubgroupDao dao = transaction.createDao(SubgroupDao.class);
            return dao.findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
