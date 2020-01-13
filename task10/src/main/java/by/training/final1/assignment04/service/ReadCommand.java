package by.training.final1.assignment04.service;

import by.training.final1.assignment02.dao.exception.DAOException;
import by.training.final1.assignment02.service.exception.ServiceException;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.dao.DAOFactory;
import by.training.final1.assignment04.dao.TreasuresReader;

import java.io.File;
import java.util.List;

public class ReadCommand {
    public List<Treasure> readTreasures(File file, int quantity) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        TreasuresReader treasuresReader = daoFactory.getTreasuresReader();
        try {
            return treasuresReader.read(file, quantity);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't read data", e.getCause());
        }
    }
}
