package by.training.twodimensionalarrays.assignment10.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.creator.MatrixCreator;
import by.training.twodimensionalarrays.exampletask.service.action.GetColumn;
import by.training.twodimensionalarrays.exampletask.service.action.GetRow;
import by.training.twodimensionalarrays.exampletask.view.ConsoleHelper;

public class Runner {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        MatrixCreator creator = new MatrixCreator();
        try {
            Matrix matrix = new Matrix(SIZE, SIZE);
            creator.fillRandomized(matrix, 1, 10);
            consoleHelper.printMatrix(matrix);
            int k = consoleHelper.readIndex(SIZE);
            int p = consoleHelper.readIndex(SIZE);
            consoleHelper.printMessage("Line " + k + ":");
            consoleHelper.printMessage(new GetRow().exec(matrix, k));
            consoleHelper.printMessage("Column " + p + ":");
            consoleHelper.printMessage(new GetColumn().exec(matrix, p));
        } catch (MatrixException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
