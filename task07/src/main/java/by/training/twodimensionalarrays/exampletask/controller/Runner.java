package by.training.twodimensionalarrays.exampletask.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.creator.MatrixAssignment20;
import by.training.twodimensionalarrays.exampletask.creator.MatrixAssignment21;
import by.training.twodimensionalarrays.exampletask.creator.MatrixAssignment31;
import by.training.twodimensionalarrays.exampletask.creator.exception.CreationException;
import by.training.twodimensionalarrays.exampletask.service.WriteMatrixCommand;
import by.training.twodimensionalarrays.exampletask.service.action.CountCommand;
import by.training.twodimensionalarrays.exampletask.service.action.GetColumn;
import by.training.twodimensionalarrays.exampletask.service.action.GetRow;
import by.training.twodimensionalarrays.exampletask.service.action.Multiplicator;
import by.training.twodimensionalarrays.exampletask.creator.MatrixCreator;
import by.training.twodimensionalarrays.exampletask.service.exception.ServiceException;
import by.training.twodimensionalarrays.exampletask.view.ConsoleHelper;

import java.io.File;

public class Runner {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        MatrixCreator creator = new MatrixCreator();
        try {
            consoleHelper.printMessage("1 - get k row and p column");
            consoleHelper.printMessage("2 - get matrix from assignment 20");
            consoleHelper.printMessage("3 - get matrix from assignment 21");
            consoleHelper.printMessage("4 - get matrix from assignment 31");
            consoleHelper.printMessage("e - exit");
            while (true) {
                consoleHelper.printMessage("Enter command");
                String choice = consoleHelper.readString();
                switch (choice) {
                    case "1": {
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
                    case "2": {
                        int n = consoleHelper.readEvenInt();
                        MatrixAssignment20 matrixCreator = new MatrixAssignment20();
                        Matrix matrix = matrixCreator.createMatrix(n);
                        consoleHelper.printMatrix(matrix);
                        break;
                    }
                    case "3": {
                        int n = consoleHelper.readEvenInt();
                        MatrixAssignment21 matrixCreator = new MatrixAssignment21();
                        Matrix matrix = matrixCreator.createMatrix(n);
                        consoleHelper.printMatrix(matrix);
                        break;
                    }
                    case "4": {
                        MatrixAssignment31 matrixCreator = new MatrixAssignment31();
                        Matrix matrix = matrixCreator.createMatrix();
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

        /*WriteMatrixCommand command = new WriteMatrixCommand();
        try {
            MatrixCreator creator = new MatrixCreator();
            Matrix p = new Matrix(2, 3);
            File file = new File("/Users/ivansilaev/Desktop/javaTraining/task07/src/main/java/by/training/twodimensionalarrays/exampletask/resources/input.txt");
            creator.fillFromFile(p, file);
            consoleHelper.printMatrix(p);
            Matrix q = new Matrix(3, 2);
            creator.fillRandomized(q, 1, 2);
            consoleHelper.printMatrix(q);
            Multiplicator multiplicator = new Multiplicator();
            Matrix result = multiplicator.multiply(p, q);
            command.exec(result);
        } catch (MatrixException e) {
            consoleHelper.printMessage(e.getMessage());
        } catch (CreationException e) {
            consoleHelper.printMessage(e.getMessage());
        } catch (ServiceException e) {
            consoleHelper.printMessage(e.getMessage());
        }*/
    }
}
