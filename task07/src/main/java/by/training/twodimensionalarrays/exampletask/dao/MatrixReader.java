package by.training.twodimensionalarrays.exampletask.dao;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MatrixReader {
    private static String fileName = "/Users/ivansilaev/Desktop/javaTraining/task07/src/main/java/by/training/twodimensionalarrays/exampletask/resources/input.txt";

    public void read(Matrix matrix, File file) throws DAOException {
        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            Object[] array = stream.toArray();
            int m = matrix.getVerticalSize();
            int n = matrix.getHorizontalSize();
            for (int i = 0; i < m; ++i) {
                String[] line = ((String) (array[i])).split(" ");
                for (int j = 0; j < n; ++j) {
                    matrix.setElement(i, j, Integer.parseInt(line[j]));
                }
            }
        } catch (IOException | MatrixException e) {
            throw new DAOException("Couldn't read from file");
        }
    }
}
