package ft.training.by.dao.mysql;

import java.sql.Connection;

public abstract class DaoImpl {
    protected static final Integer BAD_CREATION_CODE = -1;

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
