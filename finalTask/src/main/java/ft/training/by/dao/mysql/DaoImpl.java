package ft.training.by.dao.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DaoImpl {
    private static final Logger LOGGER = LogManager.getLogger();

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeStatement(Statement statement) {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            LOGGER.error("Couldn't close statement", e);
        }
    }
}
