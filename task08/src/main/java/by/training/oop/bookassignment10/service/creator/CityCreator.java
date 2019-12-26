package by.training.oop.bookassignment10.service.creator;

import by.training.oop.bookassignment10.dao.CityReader;
import by.training.oop.bookassignment10.dao.exception.DAOException;
import by.training.oop.bookassignment10.service.creator.exception.CreationException;

public class CityCreator {
    public String getRandomCity() throws CreationException {
        CityReader reader = new CityReader();
        try {
            return reader.readRandomCity();
        } catch (DAOException e) {
            throw new CreationException("Couldn't create an object");
        }
    }
}
