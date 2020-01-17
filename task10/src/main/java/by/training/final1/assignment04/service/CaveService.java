package by.training.final1.assignment04.service;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.repository.ListTreasureRepository;
import by.training.final1.assignment04.service.exception.ServiceException;
import by.training.final1.assignment04.service.validator.Validator;

import java.io.File;

public class CaveService {
    public void addTreasuresFromFile(Cave cave, File file) throws ServiceException {
        ReadTreasuresCommand command = new ReadTreasuresCommand();
        Treasure[] treasures = command.readTreasures(file);
        Validator validator = new Validator();
        for (Treasure treasure : treasures) {
            validator.validate(treasure);
        }
        ListTreasureRepository treasureRepository = ListTreasureRepository.getInstance();
        treasureRepository.add(cave, treasures);
    }
}
