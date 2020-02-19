package informationhandlinglight.training.by.dao;

import informationhandlinglight.training.by.dao.exception.DAOException;

public interface TextDAO {
    String readText() throws DAOException;
}
