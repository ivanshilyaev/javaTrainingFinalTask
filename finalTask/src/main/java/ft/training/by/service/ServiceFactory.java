package ft.training.by.service;

import ft.training.by.service.exception.ServiceException;

import java.util.Optional;

public interface ServiceFactory {
    <T extends Service> Optional<T> createService(Class<T> key) throws ServiceException;

    void close();
}
