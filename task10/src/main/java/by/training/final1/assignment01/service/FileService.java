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
            if (temp.exists()) {
                throw new ServiceException("File already exists");
            }
            if (!temp.createNewFile()) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ServiceException("Couldn't create file", e.getCause());
        }
    }

    public void rename(TrainingFile file, String newName) throws ServiceException {
        try {
            parser.parseFileName(newName);
            File temp = new File(file.getDirectory().getName() + DEL
                    + file.getName());
            File temp2 = new File(file.getDirectory().getName() + DEL
                    + newName);
            if (temp2.exists()) {
                throw new ServiceException("File already exists");
            }
            if (!temp.renameTo(temp2)) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ServiceException("Couldn't rename file", e.getCause());
        }
    }

    public void delete(TrainingFile file) throws ServiceException {
        try {
            File temp = new File(file.getDirectory().getName() + DEL
                    + file.getName());
            if (!temp.delete()) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ServiceException("Couldn't delete file", e.getCause());
        }
    }
}
