package by.training.twodimensionalarrays.exampletask.service.action;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class CountCommand {
    private boolean isDoubleDigit(int i) {
        return Math.abs(i) / 100 == 0 && Math.abs(i) / 10 > 0;
    }

    public int countNumberOfOfDoubleDigitElement(Matrix matrix) {
        int num = 0;
        try {
            for (int i = 0; i < matrix.getVerticalSize(); ++i) {
                for (int j = 0; j < matrix.getHorizontalSize(); ++j) {
                    if (isDoubleDigit(matrix.getElement(i, j))) {
                        ++num;
                    }
                }
            }
        } catch (MatrixException e) {
        }
        return num;
    }
}
