package ft.training.by.service;

import ft.training.by.bean.Subgroup;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SubgroupService extends Service {
    List<Subgroup> findAll() throws ServiceException;

    Optional<Subgroup> findEntityById(Integer id) throws ServiceException;
}
