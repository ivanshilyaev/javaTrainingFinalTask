package by.training.demothreads.matrixelement.service;

import by.training.demothreads.matrix.bean.exception.MatrixException;
import by.training.demothreads.matrixelement.bean.ElementMatrix;
import by.training.demothreads.matrixelement.service.exception.ServiceException;

import java.util.Random;

public class ElementMatrixFiller {
    public void fillRandomly(ElementMatrix matrix) throws ServiceException {
        try {
            Random random = new Random();
            for (int i = 0; i < matrix.getVerticalSize(); ++i) {
                for (int j = 0; j < matrix.getHorizontalSize(); ++j) {
                    matrix.setElement(i, j, random.nextInt(100));
                }
            }
        } catch (MatrixException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void emptyMatrix(ElementMatrix matrix) throws ServiceException {
        try {
            for (int i = 0; i < matrix.getVerticalSize(); ++i) {
                for (int j = 0; j < matrix.getHorizontalSize(); ++j) {
                    matrix.setElement(i, j, 0);
                }
            }
        } catch (MatrixException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
