package by.training.twodimensionalarrays.exampletask.dao;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.dao.exception.DAOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MatrixWriter {
    private static String fileName = "/Users/ivansilaev/Desktop/javaTraining/task07/src/main/java/by/training/twodimensionalarrays/exampletask/resources/output.txt";

    public void write(Matrix matrix) throws DAOException {
        try {
            Files.write(Paths.get(fileName), (matrix.toString()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException("Couldn't wtite to file");
        }
    }
}
