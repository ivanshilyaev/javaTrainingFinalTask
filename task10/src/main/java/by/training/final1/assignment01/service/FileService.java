package by.training.final1.assignment01.service;

import by.training.final1.assignment01.bean.TextTrainingFile;
import by.training.final1.assignment01.bean.TrainingFile;
import by.training.final1.assignment01.dao.FileReader;
import by.training.final1.assignment01.dao.FileWriter;
import by.training.final1.assignment01.dao.exception.DAOException;
import by.training.final1.assignment01.service.exception.ServiceException;
import by.training.final1.assignment01.service.parser.Parser;
import by.training.final1.assignment01.dao.DAOFactory;

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

    public String[] getContent(TrainingFile file) throws ServiceException {
        if (!(file instanceof TextTrainingFile)) {
            throw new ServiceException("Couldn't get content: not a txt file");
        }
        File temp = new File(file.getDirectory().getName() + DEL
                + file.getName());
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileReader fileReader = daoFactory.getFileReader();
        try {
            return fileReader.readData(temp);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't read data", e.getCause());
        }
    }

    public void append(TrainingFile file, String[] text) throws ServiceException {
        if (!(file instanceof TextTrainingFile)) {
            throw new ServiceException("Couldn't append to file: not a txt file");
        }
        File temp = new File(file.getDirectory().getName() + DEL
                + file.getName());
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileWriter fileWriter = daoFactory.getFileWriter();
        try {
            fileWriter.writeData(text, temp);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't append data", e.getCause());
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
