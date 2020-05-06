package ft.training.by.service.interfaces;

import ft.training.by.bean.Subgroup;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SubgroupService extends Service {
    List<Subgroup> read() throws ServiceException;

    Optional<Subgroup> read(Integer id) throws ServiceException;

    Optional<Subgroup> findBySubgroupNumberAndGroupId(char subgroupNum, Integer id)
            throws ServiceException;
}
