package by.training.final1.assignment02.dao;

import by.training.final1.assignment02.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter {
    public void writeData(String[] data, File file) throws DAOException {
        try {
            for (String datum : data) {
                Files.write(Paths.get(file.getAbsolutePath()),
                        (datum + '\n').getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new DAOException("Couldn't write to file", e.getCause());
        }
    }
}
