package by.training.twodimensionalarrays.exampletask.creator;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.creator.exception.CreationException;
import by.training.twodimensionalarrays.exampletask.dao.DAOFactory;
import by.training.twodimensionalarrays.exampletask.dao.MatrixReader;
import by.training.twodimensionalarrays.exampletask.dao.exception.DAOException;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;

public class MatrixFiller {
    public void fillRandomized(Matrix matrix, int start, int finish) {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < h; ++j) {
                int value = (int) (Math.random() * (finish - start + 1) + start);
                try {
                    matrix.setElement(i, j, value);
                } catch (MatrixException e) {
                    // couldn't be an exception here
                }
            }
        }
    }

    public void fillFromFile(Matrix matrix, File file) throws CreationException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixReader matrixReader = daoFactory.getMatrixReader();
        try {
            matrixReader.read(matrix, file);
        } catch (DAOException e) {
            throw new CreationException("Couldn't create matrix from file");
        }
    }

    public void fillFromStream(Matrix matrix, InputStream stream) {
    }

    public void fillFromDataBase(Matrix matrix, Connection connection) {
    }
}
