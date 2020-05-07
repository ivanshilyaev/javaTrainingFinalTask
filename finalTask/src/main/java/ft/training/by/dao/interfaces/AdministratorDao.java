package ft.training.by.dao.interfaces;

import ft.training.by.bean.Administrator;
import ft.training.by.dao.exception.DAOException;

import java.util.Optional;

public interface AdministratorDao extends Dao<Integer, Administrator> {
    Optional<Administrator> findByUserId(Integer id) throws DAOException;
}
