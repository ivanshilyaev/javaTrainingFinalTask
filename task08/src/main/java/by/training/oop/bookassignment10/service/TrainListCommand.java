package by.training.oop.bookassignment10.service;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.creator.exception.CreationException;

public class TrainListCommand {
    public Train[] getListOfSuitableTrains(Train[] trains, String destination) throws CreationException {
        int count = 0;
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                ++count;
            }
        }
        if (count == 0) {
            throw new CreationException("No suitable trains!");
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
}
