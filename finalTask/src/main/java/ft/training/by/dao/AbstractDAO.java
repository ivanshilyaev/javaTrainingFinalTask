package ft.training.by.dao;

import ft.training.by.bean.Entity;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<K, T extends Entity> {
    private static final Logger LOGGER = LogManager.getLogger();

    public abstract List<T> findAll() throws DAOException;

    public abstract T findEntityById(K id);

    public abstract boolean delete(K id);

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract T update(T entity);

    public void close(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("Couldn't close statement: " + e.getMessage());
        }
    }

    public void close(Connection connection) throws DAOException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException("Couldn't read data");
            }
        }
    }
}
