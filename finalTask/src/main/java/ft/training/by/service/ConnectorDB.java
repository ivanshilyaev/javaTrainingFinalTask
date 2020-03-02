package ft.training.by.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/account_db";
        String login = "root";
        String password = "shilyaevIV14332001";
        return DriverManager.getConnection(url, login, password);
    }
}
