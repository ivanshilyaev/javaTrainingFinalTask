package by.training.final1.assignment02.service;

import by.training.final1.assignment02.dao.DAOFactory;
import by.training.final1.assignment02.dao.FileWriter;
import by.training.final1.assignment02.dao.exception.DAOException;
import by.training.final1.assignment02.service.exception.ServiceException;

import java.io.File;

public class WriteChequeCommand {
    public void write(String cheque, File file) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileWriter fileWriter = daoFactory.getFileWriter();
        try {
            fileWriter.writeData(new String[]{cheque}, file);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't write data", e.getCause());
        }
    }
}
