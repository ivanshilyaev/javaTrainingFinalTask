package by.training.oop.bookassignment10.service;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.dao.TrainWriter;
import by.training.oop.bookassignment10.dao.exception.DAOException;
import by.training.oop.bookassignment10.service.exception.ServiceException;

public class TrainPrintCommand {
    public void printTrain(Train train) throws ServiceException {
        TrainWriter writer = new TrainWriter();
        try {
            writer.writeTrain(train);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't print data");
        }
    }

    public void printTrains(Train[] trains, String message) throws ServiceException {
        TrainWriter writer = new TrainWriter();
        try {
            writer.writeTrains(trains, message);
        } catch (DAOException e) {
            throw new ServiceException("Couldn't print data");
        }
    }
}
