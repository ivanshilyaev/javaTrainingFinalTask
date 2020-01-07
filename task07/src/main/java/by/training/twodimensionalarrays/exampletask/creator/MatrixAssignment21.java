package by.training.twodimensionalarrays.exampletask.creator;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class MatrixAssignment21 {
    public Matrix createMatrix(int n) {
        Matrix matrix = null;
        try {
            matrix = new Matrix(n, n);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n - i; ++j) {
                    matrix.setElement(n - i - 1, j, i + j + 1);
                }
            }
        } catch (MatrixException e) {
        }
        return matrix;
    }
}
