package by.training.twodimensionalarrays.assignment31.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.view.ConsoleHelper;

public class Runner {
    public static boolean isDoubleDigit(int i) {
        return Math.abs(i) / 100 == 0 && Math.abs(i) / 10 > 0;
    }

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        try {
            Matrix matrix = new Matrix(100, 10);
            int numberOfDoubleDigitNumbers = 0;
            int k = 0;
            for (int i = 0; i < matrix.getVerticalSize(); ++i) {
                for (int j = 0; j < matrix.getHorizontalSize(); ++j) {
                    if (isDoubleDigit(k)) {
                        ++numberOfDoubleDigitNumbers;
                    }
                    matrix.setElement(i, j, k++);
                }
            }
            consoleHelper.printMatrix(matrix);
            consoleHelper.printMessage("Number of double digit numbers: " + numberOfDoubleDigitNumbers);
        } catch (MatrixException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
