package by.training.twodimensionalarrays.exampletask.service.creator;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;

public class MatrixCreator {
    public void fillRandomized(Matrix matrix, int start, int finish) {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < h; ++j) {
                int value = (int) (Math.random() * (finish - start) + start);
                try {
                    matrix.setElement(i, j, value);
                } catch (MatrixException e) {
                    // couldn't be an exception here
                }
            }
        }
    }

    public void fillFromFile(Matrix matrix, File file) {
    }

    public void fillFromStream(Matrix matrix, InputStream stream) {
    }

    public void fillFromDataBase(Matrix matrix, Connection connection) {
    }
}
