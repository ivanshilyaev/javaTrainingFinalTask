package by.training.oop.bookassignment10.dao;

import by.training.oop.bookassignment10.validator.Validator;
import by.training.oop.bookassignment10.bean.Seat;
import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.dao.exception.DAOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Stream;

public class TrainReader {
    private static String fileName = "/Users/ivansilaev/Desktop/javaTraining/task08/src/main/java/by/training/oop/bookassignment10/resources/input.txt";
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    public Train[] readTrains() throws DAOException {
        String[] entries;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            Object[] array = stream.toArray();
            entries = Arrays.copyOf(array, array.length, String[].class);
        } catch (IOException e) {
            throw new DAOException("Couldn't read from file", e.getCause());
        }
        Train[] trains = new Train[entries.length];
        try {
            for (int i = 0; i < trains.length; ++i) {
                String[] array = entries[i].split("[^a-zA-Z0-9:.\\-]");
                trains[i] = new Train();
                trains[i].setDestination(array[0]);
                trains[i].setTrainNumber(Integer.parseInt(array[1]));
                trains[i].setDepartureTime(formatter.parse(array[2] + " " + array[3]));
                int common = Integer.parseInt(array[4]);
                int compartment = Integer.parseInt(array[5]);
                int openCoupes = Integer.parseInt(array[6]);
                int luxury = Integer.parseInt(array[7]);
                EnumMap<Seat, Integer> numberOfSeats = new EnumMap<>(Seat.class);
                numberOfSeats.put(Seat.COMMON, common);
                numberOfSeats.put(Seat.COMPARTMENT, compartment);
                numberOfSeats.put(Seat.OPEN_COUPES, openCoupes);
                numberOfSeats.put(Seat.LUXURY, luxury);
                trains[i].setNumberOfSeats(numberOfSeats);
                if (!Validator.isValid(trains[i])) {
                    throw new DAOException("Validation error");
                }
            }
        } catch (ParseException | NumberFormatException e) {
            throw new DAOException("Invalid parameter", e.getCause());
        }
        return trains;
    }
}
