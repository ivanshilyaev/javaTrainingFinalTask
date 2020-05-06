package ft.training.by.dao.mysql;

import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionImpl implements Transaction {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Map<Class<? extends Dao<?, ?>>, DaoImpl>
            repository = new ConcurrentHashMap<>();

    static {
        repository.put(FacultyDao.class, new FacultyDaoImpl());
        repository.put(GroupDao.class, new GroupDaoImpl());
        repository.put(SubgroupDao.class, new SubgroupDaoImpl());
        repository.put(UserDao.class, new UserDaoImpl());
        repository.put(StudentDao.class, new StudentDaoImpl());
        repository.put(TutorDao.class, new TutorDaoImpl());
        repository.put(AdministratorDao.class, new AdministratorDaoImpl());
        repository.put(SubjectDao.class, new SubjectDaoImpl());
        repository.put(ClassroomDao.class, new ClassroomDaoImpl());
        repository.put(TimetableDao.class, new TimetableDaoImpl());
        repository.put(TimetableGroupDao.class, new TimetableGroupDaoImpl());
    }

    private Connection connection;

    public TransactionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends Dao<?, ?>> T createDao(Class<T> key) throws DAOException {
        DaoImpl dao = repository.get(key);
        if (dao != null) {
            dao.setConnection(connection);
            return (T) dao;
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
