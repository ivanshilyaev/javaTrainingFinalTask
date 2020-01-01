package by.training.twodimensionalarrays.exampletask.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.creator.exception.CreationException;
import by.training.twodimensionalarrays.exampletask.service.WriteMatrixCommand;
import by.training.twodimensionalarrays.exampletask.service.action.Multiplicator;
import by.training.twodimensionalarrays.exampletask.creator.MatrixCreator;
import by.training.twodimensionalarrays.exampletask.service.exception.ServiceException;
import by.training.twodimensionalarrays.exampletask.view.ConsoleHelper;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        WriteMatrixCommand command = new WriteMatrixCommand();
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
        }

    }
}
