package by.training.oop.bookassignment10.controller;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.TrainListCommand;
import by.training.oop.bookassignment10.service.creator.TrainCreator;
import by.training.oop.bookassignment10.service.creator.exception.CreationException;
import by.training.oop.bookassignment10.service.exception.ServiceException;
import by.training.oop.bookassignment10.view.ConsoleHelper;
import by.training.oop.bookassignment10.view.exception.InvalidParameterException;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        TrainCreator creator = new TrainCreator();
        ConsoleHelper consoleHelper = new ConsoleHelper();
        TrainListCommand command = new TrainListCommand();
        try {
            Train[] trains = creator.createTrainArray(10);
            consoleHelper.printTrains(trains, "Train array:");

            // #1 list of trains, going to a given destination
            String destination = consoleHelper.readLine("1. Enter a destination:");
            Train[] list1 = command.getListOfSuitableTrains(trains, destination);
            consoleHelper.printTrains(list1, "List of trains, going to a given destination:");

            // #2 list of trains, going to a given destination
            // and living after a given day (date)
            destination = consoleHelper.readLine("2. Enter a destination:");
            Date date = consoleHelper.readDate("Enter date in format dd.mm.yyyy HH:mm" +
                    " after which you'd line to search the train");
            Train[] list2 = command.getListOfSuitableTrains(trains, destination, date);
            consoleHelper.printTrains(list2, "List of trains, going to a given destination" +
                    " and living after a given day:");

            // #3 list of trains with common seats, going to a given destination
        } catch (CreationException e) {
            consoleHelper.printString(e.getMessage());
        } catch (ServiceException e) {
            consoleHelper.printString(e.getMessage());
        } catch (InvalidParameterException e) {
            consoleHelper.printString(e.getMessage());
        }
        // each exception could be processed differently
    }
}
