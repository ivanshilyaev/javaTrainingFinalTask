package by.training.final1.assignment01.service;

import by.training.final1.assignment01.bean.TrainingDirectory;
import by.training.final1.assignment01.service.exception.ServiceException;

import java.io.File;
import java.io.IOException;

public class DirectoryService {
    public void create(TrainingDirectory directory) throws ServiceException {
        File temp = new File(directory.getName());
        if (temp.exists()) {
            throw new ServiceException("Directory already exists");
        }
        if (!temp.mkdir()) {
            throw new ServiceException("Couldn't create directory");
        }
    }

    public void delete(TrainingDirectory directory) throws ServiceException {
        try {
            File temp = new File(directory.getName());
            if (!temp.delete()) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ServiceException("Couldn't delete directory", e.getCause());
        }
    }
}
