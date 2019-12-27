package by.training.oop.bookassignment10.creator;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.dao.DAOFactory;
import by.training.oop.bookassignment10.dao.TrainReader;
import by.training.oop.bookassignment10.dao.exception.DAOException;
import by.training.oop.bookassignment10.service.FillRandom;
import by.training.oop.bookassignment10.creator.exception.CreationException;

public class TrainCreator {
    public Train[] createRandomTrainArray(int size) throws CreationException {
        Train[] trains = new Train[size];
        CityCreator cityCreator = new CityCreator();
        FillRandom fillRandom = new FillRandom();
        for (int i = 0; i < 10; ++i) {
            trains[i] = new Train(cityCreator.getRandomCity());
            fillRandom.fill(trains[i]);
        }
        return trains;
    }

    public Train[] readTrainArrayFromFile() throws CreationException {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        TrainReader reader = daoObjectFactory.getTrainReader();
        try {
            return reader.readTrains();
        } catch (DAOException e) {
            if (e.getMessage().equalsIgnoreCase("Validation error")) {
                throw new CreationException("Couldn't create an object due to " +
                        "validation error");
            }
            throw new CreationException("Couldn't create an object");
        }
    }
}
