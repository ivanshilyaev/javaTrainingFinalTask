package informationhandlinglight.training.by.dao;

import informationhandlinglight.training.by.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileTextDAO implements TextDAO {
    private static final String NAME = "/Users/ivansilaev/Desktop/javaTraining/task11/src/main/java/informationhandlinglight/training/by/resources/test.txt";

    @Override
    public String readText() throws DAOException {
        String[] entries;
        try (Stream<String> stream = Files.lines(Paths.get(new File(NAME).getAbsolutePath()))) {
            Object[] array = stream.toArray();
            entries = Arrays.copyOf(array, array.length, String[].class);
        } catch (IOException e) {
            throw new DAOException("Couldn't read from file", e.getCause());
        }
        StringBuilder builder = new StringBuilder();
        for (String line : entries) {
            builder.append(line).append("\r\n");
        }
        return builder.toString();
    }
}
