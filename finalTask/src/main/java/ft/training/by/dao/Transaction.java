package ft.training.by.dao;

import ft.training.by.dao.exception.DAOException;

public interface Transaction {
    <T extends Dao<?, ?>> T createDao(Class<T> key) throws DAOException;

    void commit();

    void rollback();
}
