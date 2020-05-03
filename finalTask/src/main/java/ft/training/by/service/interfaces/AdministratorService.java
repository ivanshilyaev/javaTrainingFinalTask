package ft.training.by.service.interfaces;

import ft.training.by.bean.Administrator;
import ft.training.by.service.exception.ServiceException;

import java.util.List;

public interface AdministratorService extends Service {
    List<Administrator> findAll() throws ServiceException;
}
