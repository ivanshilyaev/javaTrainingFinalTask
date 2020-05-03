package ft.training.by.service.interfaces;

import ft.training.by.bean.TimetableGroup;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface TimetableGroupService extends Service {
    List<TimetableGroup> findAll() throws ServiceException;
}
