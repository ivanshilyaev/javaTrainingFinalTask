package by.training.twodimensionalarrays.exampletask.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.creator.*;
import by.training.twodimensionalarrays.exampletask.service.action.CountCommand;
import by.training.twodimensionalarrays.exampletask.service.action.GetColumn;
import by.training.twodimensionalarrays.exampletask.service.action.GetRow;
import by.training.twodimensionalarrays.exampletask.view.ConsoleHelper;

public class Runner {
    public static final int SIZE = 10;

    public void showMune(ConsoleHelper consoleHelper) {
        consoleHelper.printMessage("10 - get k row and p column");
        consoleHelper.printMessage("20 - get matrix from assignment 20");
        consoleHelper.printMessage("21 - get matrix from assignment 21");
        consoleHelper.printMessage("31 - get matrix from assignment 31");
        consoleHelper.printMessage("e - exit");
    }

    public String runDialog(ConsoleHelper consoleHelper) {
        consoleHelper.printMessage("\n" + "Enter command:");
        return consoleHelper.readString();
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
        MatrixFiller creator = new MatrixFiller();
        CreateMatrixCommand creationCommand;
        try {
            runner.showMune(consoleHelper);
            while (true) {
                String choice = runner.runDialog(consoleHelper);
                switch (choice) {
                    case "10": {
                        Matrix matrix = new Matrix(SIZE, SIZE);
                        creator.fillRandomized(matrix, 1, 10);
                        consoleHelper.printMatrix(matrix);
                        int k = consoleHelper.readIndex(SIZE);
                        int p = consoleHelper.readIndex(SIZE);
                        consoleHelper.printMessage("Row " + k + ":");
                        consoleHelper.printMessage(new GetRow().exec(matrix, k));
                        consoleHelper.printMessage("Column " + p + ":");
                        consoleHelper.printMessage(new GetColumn().exec(matrix, p));
                        break;
                    }
                    case "20": {
                        int n = consoleHelper.readEvenInt();
                        creationCommand = new MatrixAssignment20();
                        Matrix matrix = creationCommand.createMatrix(n, n);
                        consoleHelper.printMatrix(matrix);
                        break;
                    }
                    case "21": {
                        int n = consoleHelper.readEvenInt();
                        creationCommand = new MatrixAssignment21();
                        Matrix matrix = creationCommand.createMatrix(n, n);
                        consoleHelper.printMatrix(matrix);
                        break;
                    }
                    case "31": {
                        creationCommand = new MatrixAssignment31();
                        Matrix matrix = creationCommand.createMatrix(1, 1);
                        consoleHelper.printMatrix(matrix);
                        CountCommand command = new CountCommand();
                        consoleHelper.printMessage("Number of double digit numbers: " +
                                command.countNumberOfOfDoubleDigitElement(matrix));
                        break;
                    }
                    case "e": {
                        return;
                    }
                    default: {
                        consoleHelper.printMessage("Wrong command. Try again:");
                        break;
                    }
                }
            }
        } catch (MatrixException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
