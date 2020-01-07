package by.training.twodimensionalarrays.exampletask.service.action;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class GetRow {
    public String exec(Matrix matrix, int k) throws MatrixException {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < matrix.getHorizontalSize(); ++j) {
            builder.append(matrix.getElement(k, j)).append(" ");
        }
        return builder.toString();
    }
}
