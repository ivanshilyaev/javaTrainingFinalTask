package by.training.final1.assignment02.service;

import by.training.final1.assignment02.dao.DAOFactory;
import by.training.final1.assignment02.dao.FileReader;
import by.training.final1.assignment02.dao.exception.DAOException;
import by.training.final1.assignment02.service.exception.ServiceException;

import java.io.File;

public final class ReadCommodityCommand {
    private static final ReadCommodityCommand INSTANCE = new ReadCommodityCommand();

    private ReadCommodityCommand() {
    }

    public static ReadCommodityCommand getInstance() {
        return INSTANCE;
    }

    public String[] read(File file) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileReader fileReader = daoFactory.getFileReader();
        try {
            return fileReader.readData(file);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't read data", e.getCause());
        }
    }
}
