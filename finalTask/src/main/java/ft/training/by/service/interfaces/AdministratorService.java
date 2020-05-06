package ft.training.by.service.interfaces;

import ft.training.by.bean.Administrator;
import ft.training.by.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface AdministratorService extends Service {
    List<Administrator> read() throws ServiceException;

    Optional<Administrator> read(Integer id) throws ServiceException;
}
