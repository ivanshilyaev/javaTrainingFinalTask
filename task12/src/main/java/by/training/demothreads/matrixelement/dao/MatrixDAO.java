package by.training.demothreads.matrixelement.dao;

import by.training.demothreads.matrixelement.bean.ElementMatrix;
import by.training.demothreads.matrixelement.dao.exception.DAOException;

public interface MatrixDAO {
    void readMatrix(ElementMatrix matrix) throws DAOException;
}
