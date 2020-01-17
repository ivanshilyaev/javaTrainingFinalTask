package by.training.final1.assignment04.service;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.dao.DAOFactory;
import by.training.final1.assignment04.dao.FileReader;
import by.training.final1.assignment04.dao.FileWriter;
import by.training.final1.assignment04.dao.exception.DAOException;
import by.training.final1.assignment04.repository.ListTreasureRepository;
import by.training.final1.assignment04.service.exception.ServiceException;
import by.training.final1.assignment04.service.validator.Validator;

import java.io.File;

public class CaveService {
    public void addTreasures(Cave cave, File file) throws ServiceException {
        ReadTreasuresCommand command = new ReadTreasuresCommand();
        Treasure[] treasures = command.readTreasures(file);
        Validator validator = new Validator();
        for (Treasure treasure : treasures) {
            validator.validateTreasure(treasure);
        }
        ListTreasureRepository treasureRepository = ListTreasureRepository.getInstance();
        treasureRepository.add(cave, treasures);
    }

    public String[] readListOfCommands(File file) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileReader fileReader = daoFactory.getFileReader();
        Validator validator = new Validator();
        try {
            String[] items = fileReader.readData(file);
            for (String item : items) {
                validator.validateCommand(item);
            }
            return items;
        } catch (DAOException e) {
            throw new ServiceException("Couldn't read data", e.getCause());
        }
    }

    public void writeResponse(String response, File file) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        FileWriter fileWriter = daoFactory.getFileWriter();
        try {
            fileWriter.writeData(new String[]{response}, file);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't write data", e.getCause());
        }
    }
}
