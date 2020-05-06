package ft.training.by.service.impl;

import ft.training.by.dao.interfaces.Transaction;
import ft.training.by.dao.interfaces.TransactionFactory;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.mysql.TransactionFactoryImpl;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ServiceFactoryImpl implements ServiceFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Map<Class<? extends Service>, ServiceImpl>
            repository = new ConcurrentHashMap<>();

    static {
        repository.put(FacultyService.class, new FacultyServiceImpl());
        repository.put(GroupService.class, new GroupServiceImpl());
        repository.put(SubgroupService.class, new SubgroupServiceImpl());
        repository.put(UserService.class, new UserServiceImpl());
        repository.put(StudentService.class, new StudentServiceImpl());
        repository.put(TutorService.class, new TutorServiceImpl());
        repository.put(AdministratorService.class, new AdministratorServiceImpl());
        repository.put(SubjectService.class, new SubjectServiceImpl());
        repository.put(ClassroomService.class, new ClassroomServiceImpl());
        repository.put(TimetableService.class, new TimetableServiceImpl());
        repository.put(TimetableGroupService.class, new TimetableGroupServiceImpl());
    }

    private TransactionFactory factory;

    public ServiceFactoryImpl() throws ServiceException {
        try {
            factory = new TransactionFactoryImpl();
        } catch (DAOException e) {
            throw new ServiceException("Couldn't create service factory", e);
        }
    }

    @Override
    public <T extends Service> T createService(Class<T> key) throws ServiceException {
        ServiceImpl service = repository.get(key);
        if (service != null) {
            Transaction transaction = factory.createTransaction();
            service.setTransaction(transaction);
            return (T) service;
        }
        return null;
    }

    @Override
    public void close() {
        factory.close();
    }
}
