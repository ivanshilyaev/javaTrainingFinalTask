package ft.training.by.service.interfaces;

import ft.training.by.bean.Performance;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface PerformanceService extends Service {
    List<Performance> read() throws ServiceException;

    Optional<Performance> read(Integer id) throws ServiceException;

    List<Performance> findByStudentId(Integer id) throws ServiceException;
}
