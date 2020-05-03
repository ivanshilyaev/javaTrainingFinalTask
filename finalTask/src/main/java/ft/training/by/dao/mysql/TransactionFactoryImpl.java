package ft.training.by.dao.mysql;

import ft.training.by.dao.interfaces.Transaction;
import ft.training.by.dao.interfaces.TransactionFactory;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionFactoryImpl implements TransactionFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    private Connection connection;

    public TransactionFactoryImpl() throws DAOException {
        connection = ConnectionPool.getInstance().getConnection();
    }

    @Override
    public Transaction createTransaction() {
        return new TransactionImpl(connection);
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }
}
