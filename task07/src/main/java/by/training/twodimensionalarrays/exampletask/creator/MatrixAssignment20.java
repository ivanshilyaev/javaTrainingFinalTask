package by.training.twodimensionalarrays.exampletask.creator;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class MatrixAssignment20 implements CreateMatrixCommand {
    @Override
    public Matrix createMatrix(int n, int m) {
        Matrix matrix = null;
        try {
            matrix = new Matrix(n, m);
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < i + 1; ++j) {
                    matrix.setElement(i, j, 1);
                    matrix.setElement(i, n - j - 1, 1);
                    matrix.setElement(n - i - 1, j, 1);
                    matrix.setElement(n - i - 1, n - j - 1, 1);
                }
            }
        } catch (MatrixException e) {
        }
        return matrix;
    }
}
