package by.training.twodimensionalarrays.exampletask.service;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.dao.DAOFactory;
import by.training.twodimensionalarrays.exampletask.dao.MatrixWriter;
import by.training.twodimensionalarrays.exampletask.dao.exception.DAOException;
import by.training.twodimensionalarrays.exampletask.service.exception.ServiceException;

public class WriteMatrixCommand {
    public void exec(Matrix matrix) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixWriter matrixWriter = daoFactory.getMatrixWriter();
        try {
            matrixWriter.write(matrix);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't write to file");
        }
    }
}
