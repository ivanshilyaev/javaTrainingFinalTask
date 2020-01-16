package by.training.final1.assignment04.service;

import by.training.final1.assignment02.service.exception.ServiceException;
import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;

import java.io.File;

public class CaveService {
    public void addTreasures(Cave cave, File file) throws ServiceException {
        ReadTreasuresCommand command = new ReadTreasuresCommand();
        Treasure[] treasures = command.readTreasures(file);

    }
}
