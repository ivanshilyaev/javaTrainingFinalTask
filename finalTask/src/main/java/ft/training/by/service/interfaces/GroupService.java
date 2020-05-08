package ft.training.by.service.interfaces;

import ft.training.by.bean.Group;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GroupService extends Service {
    List<Group> read() throws ServiceException;

    Optional<Group> read(Integer id) throws ServiceException;

    Optional<Group> findByGroupAndCourse(int groupNum, int courseNum)
            throws ServiceException;
}
