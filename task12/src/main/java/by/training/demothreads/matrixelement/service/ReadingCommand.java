package by.training.demothreads.matrixelement.service;

import by.training.demothreads.matrixelement.bean.ElementMatrix;
import by.training.demothreads.matrixelement.dao.DAOFactory;
import by.training.demothreads.matrixelement.dao.MatrixDAO;
import by.training.demothreads.matrixelement.dao.exception.DAOException;
import by.training.demothreads.matrixelement.service.exception.ServiceException;

public class ReadingCommand {
    public void exec(ElementMatrix matrix) throws ServiceException {
        MatrixDAO matrixDAO = DAOFactory.getInstance().getMatrixDao();
        try {
            matrixDAO.readMatrix(matrix);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
