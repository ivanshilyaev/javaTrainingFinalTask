package by.training.oop.bookassignment10.view;

import by.training.oop.bookassignment10.bean.Seat;
import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.view.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumMap;
import java.util.Scanner;

public class ConsoleHelper {
    private static String destinationStr = "Destination: ";
    private static String trainNumberStr = "Train number: ";
    private static String departureTimeStr = "Departure time in format " +
            "dd.mm.yyyy HH:mm:ss : ";
    private static String commonSeatsStr = "Common seats: ";
    private static String compartmentSeatsStr = "Compartment seats: ";
    private static String openCoupesStr = "Open coupes: ";
    private static String luxurySeatsStr = "Luxury seats: ";

    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public void printTrain(Train train) {
        System.out.println(train);
    }

    public void printTrains(Train[] trains, String message) {
        System.out.println(message);
        for (Train train : trains) {
            System.out.println(train);
        }
        System.out.println();
    }

    private EnumMap<Seat, Integer> readSeats() {
        System.out.print(commonSeatsStr);
        int common = Integer.parseInt(scanner.nextLine());
        System.out.print(compartmentSeatsStr);
        int compartment = Integer.parseInt(scanner.nextLine());
        System.out.print(openCoupesStr);
        int openCoupes = Integer.parseInt(scanner.nextLine());
        System.out.print(luxurySeatsStr);
        int luxury = Integer.parseInt(scanner.nextLine());
        EnumMap<Seat, Integer> numberOfSeats = new EnumMap<>(Seat.class);
        numberOfSeats.put(Seat.COMMON, common);
        numberOfSeats.put(Seat.COMPARTMENT, compartment);
        numberOfSeats.put(Seat.OPEN_COUPES, openCoupes);
        numberOfSeats.put(Seat.LUXURY, luxury);
        return numberOfSeats;
    }

    public Train readTrain() throws InvalidParameterException {
        Train train = new Train();
        try {
            System.out.print(destinationStr);
            train.setDestination(scanner.nextLine());
            System.out.print(trainNumberStr);
            train.setTrainNumber(Integer.parseInt(scanner.nextLine()));
            System.out.print(departureTimeStr);
            train.setDepartureTime(formatter.parse(scanner.nextLine()));
            train.setNumberOfSeats(readSeats());
        } catch (ParseException | NumberFormatException e) {
            throw new InvalidParameterException("Invalid parameter", e.getCause());
        }
        return train;
    }
}
