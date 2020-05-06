package ft.training.by.dao.interfaces;

import ft.training.by.bean.Entity;
import ft.training.by.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface Dao<K, T extends Entity> {
    boolean create(T entity) throws DAOException;

    List<T> read() throws DAOException;

    Optional<T> read(K id) throws DAOException;

    T update(T entity);

    boolean delete(K id) throws DAOException;

    boolean delete(T entity) throws DAOException;
}
