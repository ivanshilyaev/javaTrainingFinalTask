package by.training.twodimensionalarrays.assignment21.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.view.ConsoleHelper;

public class Runner {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.printMessage("Int must be even");
        int n = consoleHelper.readInt();
        if (n < 1 || n % 2 == 1) {
            System.out.println("Invalid size: " + n);
            return;
        }
        try {
            Matrix matrix = new Matrix(n, n);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n - i; ++j) {
                    matrix.setElement(n - i - 1, j, i + j + 1);
                }
            }
            consoleHelper.printMatrix(matrix);
        } catch (MatrixException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
