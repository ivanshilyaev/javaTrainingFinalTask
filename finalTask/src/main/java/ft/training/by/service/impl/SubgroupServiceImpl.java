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
    public List<Subgroup> read() throws ServiceException {
        try {
            SubgroupDao dao = transaction.createDao(SubgroupDao.class);
            return dao.read();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Subgroup> read(Integer id) throws ServiceException {
        try {
            SubgroupDao dao = transaction.createDao(SubgroupDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Subgroup> findBySubgroupNumberAndGroupId(char subgroupNum, Integer id) throws ServiceException {
        try {
            SubgroupDao dao = transaction.createDao(SubgroupDao.class);
            return dao.findBySubgroupNumberAndGroupId(subgroupNum, id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
