package ft.training.by.service;

import ft.training.by.service.exception.ServiceException;

public interface ServiceFactory {
    <T extends Service> T createService(Class<T> key) throws ServiceException;

    void close();
}
