package by.training.twodimensionalarrays.exampletask.creator;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class MatrixAssignment31 {
    public Matrix createMatrix() {
        Matrix matrix = null;
        try {
            matrix = new Matrix(100, 10);
            int k = 0;
            for (int i = 0; i < matrix.getVerticalSize(); ++i) {
                for (int j = 0; j < matrix.getHorizontalSize(); ++j) {
                    matrix.setElement(i, j, k++);
                }
            }
        } catch (MatrixException e) {
        }
        return matrix;
    }
}
