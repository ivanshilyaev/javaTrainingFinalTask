package by.training.twodimensionalarrays.assignment10.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.creator.MatrixCreator;
import by.training.twodimensionalarrays.exampletask.view.ConsoleHelper;

public class Runner {
    public static final int SIZE = 10;

    public static boolean checkIndex(int index) {
        return index >= 0 && index < SIZE;
    }

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        MatrixCreator creator = new MatrixCreator();
        try {
            Matrix matrix = new Matrix(SIZE, SIZE);
            creator.fillRandomized(matrix, 1, 10);
            consoleHelper.printMatrix(matrix);
            int k = consoleHelper.readInt();
            int p = consoleHelper.readInt();
            if (!checkIndex(k)) {
                consoleHelper.printMessage("Invalid index: " + k);
            } else {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < SIZE; ++j) {
                    line.append(matrix.getElement(k, j)).append(" ");
                }
                consoleHelper.printMessage("Line " + k + ":");
                consoleHelper.printMessage(line.toString());
            }
            if (!checkIndex(p)) {
                consoleHelper.printMessage("Invalid index: " + p);
            } else {
                StringBuilder column = new StringBuilder();
                for (int i = 0; i < SIZE; ++i) {
                    column.append(matrix.getElement(i, p)).append(" ");
                }
                consoleHelper.printMessage("Column " + p + ":");
                consoleHelper.printMessage(column.toString());
            }
        } catch (MatrixException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
