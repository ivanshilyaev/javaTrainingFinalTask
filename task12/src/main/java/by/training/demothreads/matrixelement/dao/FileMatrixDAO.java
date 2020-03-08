package by.training.demothreads.matrixelement.dao;

import by.training.demothreads.matrix.bean.exception.MatrixException;
import by.training.demothreads.matrixelement.bean.ElementMatrix;
import by.training.demothreads.matrixelement.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileMatrixDAO implements MatrixDAO {
    private static String fileName = "/Users/ivansilaev/Desktop/javaTraining/task12/src/main/resources/input.txt";

    @Override
    public void readMatrix(ElementMatrix matrix) throws DAOException {
        File file = new File(fileName);
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
