package ft.training.by.service.interfaces;

import ft.training.by.service.exception.ServiceException;

public interface ServiceFactory {
    <T extends Service> T createService(Class<T> key) throws ServiceException;

    void close();
}
