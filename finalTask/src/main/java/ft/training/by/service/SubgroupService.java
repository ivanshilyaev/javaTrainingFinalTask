package ft.training.by.service;

import ft.training.by.bean.Subgroup;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface SubgroupService extends Service {
    List<Subgroup> findAll() throws ServiceException;

    Subgroup findEntityById(Integer id) throws ServiceException;
}
