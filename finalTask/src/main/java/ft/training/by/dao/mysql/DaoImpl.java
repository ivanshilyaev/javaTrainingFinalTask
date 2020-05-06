package ft.training.by.dao.mysql;

import java.sql.Connection;

public abstract class DaoImpl {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
