package by.training.final1.assignment01.service;

import by.training.final1.assignment01.bean.TrainingDirectory;
import by.training.final1.assignment01.service.exception.ServiceException;

import java.io.File;


public class DirectoryService {
    public void createNewDirectory(TrainingDirectory directory) throws ServiceException {
        File temp = new File(directory.getName());
        if (!temp.mkdir()) {
            throw new ServiceException("Couldn't create a directory");
        }
    }
}
