package by.training.twodimensionalarrays.exampletask.service.action;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class GetColumn {
    public String exec(Matrix matrix, int p) throws MatrixException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.getVerticalSize(); ++i) {
            builder.append(matrix.getElement(i, p)).append(" ");
        }
        return builder.toString();
    }
}
