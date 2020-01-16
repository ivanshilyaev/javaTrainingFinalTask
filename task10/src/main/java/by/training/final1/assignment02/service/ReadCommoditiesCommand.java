package by.training.final1.assignment02.service;

import by.training.final1.assignment02.bean.Commodity;
import by.training.final1.assignment02.dao.DAOFactory;
import by.training.final1.assignment02.dao.FileReader;
import by.training.final1.assignment02.dao.exception.DAOException;
import by.training.final1.assignment02.service.exception.ServiceException;
import by.training.final1.assignment02.service.parser.Parser;

import java.io.File;

public final class ReadCommoditiesCommand {
    private static final ReadCommoditiesCommand INSTANCE = new ReadCommoditiesCommand();

    private ReadCommoditiesCommand() {
    }

    public static ReadCommoditiesCommand getInstance() {
        return INSTANCE;
    }

    public Commodity[] read(File file) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileReader fileReader = daoFactory.getFileReader();
        try {
            String[] data = fileReader.readData(file);
            Commodity[] commodities = new Commodity[data.length];
            Parser parser = new Parser();
            for (int i = 0; i < commodities.length; ++i) {
                commodities[i] = parser.parseString(data[i]);
            }
            return commodities;
        } catch (DAOException e) {
            throw new ServiceException("Couldn't read data", e.getCause());
        }
    }
}
