package by.training.final1.assignment04.service;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.dao.DAOFactory;
import by.training.final1.assignment04.dao.FileReader;
import by.training.final1.assignment04.dao.exception.DAOException;
import by.training.final1.assignment04.service.exception.ServiceException;
import by.training.final1.assignment04.service.perser.Parser;

import java.io.File;

public class ReadTreasuresCommand {
    public Treasure[] readTreasures(File file) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileReader fileReader = daoFactory.getFileReader();
        try {
            String[] data = fileReader.readData(file);
            if (data.length != Cave.QUANTITY) {
                throw new ServiceException("Invalid number of treasures");
            }
            Parser parser = new Parser();
            Treasure[] treasures = new Treasure[Cave.QUANTITY];
            for (int i = 0; i < Cave.QUANTITY; ++i) {
                treasures[i] = parser.parseString(data[i]);
            }
            return treasures;
        } catch (DAOException e) {
            throw new ServiceException("Couldn't read data", e.getCause());
        }
    }
}
