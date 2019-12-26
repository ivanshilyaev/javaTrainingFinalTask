package by.training.oop.bookassignment10.service;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.exception.ServiceException;

import java.util.Date;

public class TrainListCommand {
    public Train[] getListOfSuitableTrains(Train[] trains, String destination)
            throws ServiceException {
        int count = 0;
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                ++count;
            }
        }
        if (count == 0) {
            throw new ServiceException("No suitable trains!");
        }
        Train[] result = new Train[count];
        int j = 0;
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                result[j++] = train;
            }
        }
        return result;
    }

    public Train[] getListOfSuitableTrains(Train[] trains, String destination, Date date)
            throws ServiceException {
        int count = 0;
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)
                    && train.getDepartureTime().compareTo(date) < 0) {
                ++count;
            }
        }
        if (count == 0) {
            throw new ServiceException("No suitable trains!");
        }
        Train[] result = new Train[count];
        int j = 0;
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)
                    && train.getDepartureTime().compareTo(date) < 0) {
                result[j++] = train;
            }
        }
        return result;
    }
}
