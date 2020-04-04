package ft.training.by.dao.mysql;

import ft.training.by.dao.*;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionImpl implements Transaction {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Map<Class<? extends Dao<?, ?>>, Class<? extends DaoImpl>>
            repository = new ConcurrentHashMap<>();

    static {
        repository.put(FacultyDao.class, FacultyDaoImpl.class);
        repository.put(GroupDao.class, GroupDaoImpl.class);
        repository.put(SubgroupDao.class, SubgroupDaoImpl.class);
        repository.put(UserDao.class, UserDaoImpl.class);
        repository.put(StudentDao.class, StudentDaoImpl.class);
    }

    private Connection connection;

    public TransactionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends Dao<?, ?>> T createDao(Class<T> key) throws DAOException {
        Class<? extends DaoImpl> value = repository.get(key);
        if (value != null) {
            try {
                DaoImpl dao = value.getDeclaredConstructor().newInstance();
                dao.setConnection(connection);
                return (T) dao;
            } catch (InstantiationException | InvocationTargetException |
                    NoSuchMethodException | IllegalAccessException e) {
                LOGGER.error("Impossible to create dao object", e);
                throw new DAOException(e);
            }
        }
        return null;
    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }
}