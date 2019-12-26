package by.training.oop.bookassignment10.dao;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.dao.exception.DAOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TrainWriter {
    private static String fileName = "/Users/ivansilaev/Desktop/javaTraining/task08/src/main/java/by/training/oop/bookassignment10/resources/output.txt";

    public void writeTrain(Train train) throws DAOException {
        try {
            Files.write(Paths.get(fileName), (train.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException("Couldn't write to file");
        }
    }

    public void writeTrains(Train[] trains, String message) throws DAOException {
        try {
            Files.write(Paths.get(fileName), (message + "\n").getBytes(), StandardOpenOption.APPEND);
            for (Train train : trains) {
                Files.write(Paths.get(fileName), (train.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
            }
            Files.write(Paths.get(fileName), "\n".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException("Couldn't write to file");
        }
    }
}
