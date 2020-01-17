package by.training.final1.assignment01.service;

import by.training.final1.assignment01.bean.TrainingFile;
import by.training.final1.assignment01.service.exception.ServiceException;
import by.training.final1.assignment01.service.parser.Parser;

import java.io.File;
import java.io.IOException;

public class FileService {
    private static final String DEL = System.getProperty("file.separator");
    private Parser parser = new Parser();

    public void create(TrainingFile file) throws ServiceException {
        try {
            parser.parseFileName(file.getName());
            File temp = new File(file.getDirectory().getName() + DEL
                    + file.getName());
            if (!temp.createNewFile()) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ServiceException("Couldn't create a file", e.getCause());
        }
    }
}
