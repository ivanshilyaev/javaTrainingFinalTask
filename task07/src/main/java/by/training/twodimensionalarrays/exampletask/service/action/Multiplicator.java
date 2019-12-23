package by.training.twodimensionalarrays.exampletask.service.action;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class Multiplicator {
    public Matrix multiply(Matrix p, Matrix q) throws MatrixException {
        int v = p.getVerticalSize();
        int h = q.getHorizontalSize();
        int tmp = p.getHorizontalSize();
        if (tmp != q.getVerticalSize()) {
            throw new MatrixException("Incompatible matrices");
        }
        Matrix result = new Matrix(v, h);
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < h; ++j) {
                int value = 0;
                for (int k = 0; k < tmp; ++k) {
                    value += p.getElement(i, k) * q.getElement(k, j);
                }
                result.setElement(i, j, value);
            }
        }
        return result;
    }
}
