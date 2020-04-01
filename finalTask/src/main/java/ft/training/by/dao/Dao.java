package ft.training.by.dao;

import ft.training.by.bean.Entity;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public interface Dao<K, T extends Entity> {
    List<T> findAll() throws DAOException;

    T findEntityById(K id) throws DAOException; // read

    boolean delete(K id);

    boolean delete(T entity);

    boolean create(T entity);

    T update(T entity);
}
