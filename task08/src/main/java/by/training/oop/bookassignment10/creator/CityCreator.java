package by.training.oop.bookassignment10.creator;

import by.training.oop.bookassignment10.dao.CityReader;
import by.training.oop.bookassignment10.dao.DAOFactory;
import by.training.oop.bookassignment10.dao.exception.DAOException;
import by.training.oop.bookassignment10.creator.exception.CreationException;

public class CityCreator {
    public String getRandomCity() throws CreationException {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        CityReader reader = daoObjectFactory.getCityReader();
        try {
            return reader.readRandomCity();
        } catch (DAOException e) {
            throw new CreationException("Couldn't create an object");
        }
    }
}
