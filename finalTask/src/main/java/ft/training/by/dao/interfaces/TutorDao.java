package ft.training.by.dao.interfaces;

import ft.training.by.bean.Tutor;
import ft.training.by.dao.exception.DAOException;

import java.util.Optional;

public interface TutorDao extends Dao<Integer, Tutor> {
    Optional<Tutor> findByUserId(Integer id) throws DAOException;
}
