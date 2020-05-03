package ft.training.by.service.interfaces;

import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.Service;

import java.util.Optional;

public interface ServiceFactory {
    <T extends Service> Optional<T> createService(Class<T> key) throws ServiceException;

    void close();
}
