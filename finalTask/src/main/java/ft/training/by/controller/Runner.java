package ft.training.by.controller;

import ft.training.by.dao.StudentDao;
import ft.training.by.dao.Transaction;
import ft.training.by.dao.TransactionFactory;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.mysql.TransactionFactoryImpl;
import ft.training.by.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String DB_URL = "jdbc:mysql://localhost:3306/account_db";
    public static final String DB_LOGIN = "application";
    public static final String DB_PASSWORD = "application_password";
    public static final int DB_POOL_START_ACTIVE = 10;
    public static final int DB_POOL_MAX_ACTIVE = 1000;
    public static final int DB_POOL_MAX_WAIT = 0;

    private static void init() {
        try {
            ConnectionPool.getInstance().init(DB_URL,
                    DB_LOGIN, DB_PASSWORD, DB_POOL_START_ACTIVE,
                    DB_POOL_MAX_ACTIVE, DB_POOL_MAX_WAIT);
        } catch (DAOException e) {
            LOGGER.error(e);
        }
    }

    public static void main(String[] args) {
        init();
        try {
            TransactionFactory transactionFactory = new TransactionFactoryImpl();
            Transaction transaction = transactionFactory.createTransaction();
            StudentDao dao = transaction.createDao(StudentDao.class);
            System.out.println(dao.findAll());
        } catch (DAOException e) {
            LOGGER.error("Failure");
        }
    }
}
