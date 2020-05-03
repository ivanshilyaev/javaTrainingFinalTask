package ft.training.by.service.interfaces;

import ft.training.by.bean.TimetableGroup;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface TimetableGroupService extends Service {
    List<TimetableGroup> findAll() throws ServiceException;

    Optional<TimetableGroup> findEntityById(Integer id) throws ServiceException;

    List<TimetableGroup> findBySubgroupId(Integer id) throws ServiceException;
}
