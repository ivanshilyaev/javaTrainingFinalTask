package ft.training.by.service.interfaces;

import ft.training.by.bean.Group;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GroupService extends Service {
    List<Group> read() throws ServiceException;

    Optional<Group> read(Integer id) throws ServiceException;

    List<Group> findByFacultyId(Integer id) throws ServiceException;

    Optional<Group> findByGroupCourseFaculty(int groupNum, int courseNum, int facultyId)
            throws ServiceException;
}
