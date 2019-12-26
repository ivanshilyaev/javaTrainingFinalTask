package by.training.oop.bookassignment10.controller;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.TrainListCommand;
import by.training.oop.bookassignment10.service.creator.TrainCreator;
import by.training.oop.bookassignment10.service.creator.exception.CreationException;
import by.training.oop.bookassignment10.view.ConsoleHelper;

public class Runner {
    public static void main(String[] args) {
        TrainCreator creator = new TrainCreator();
        ConsoleHelper consoleHelper = new ConsoleHelper();
        TrainListCommand command = new TrainListCommand();
        try {
            Train[] trains = creator.createTrainArray(10);
            consoleHelper.printTrains(trains, "Train array:");

            // #1 list of trains, going to a given destination
            String destination = consoleHelper.readLine("Enter a destination:");
            Train[] list = command.getListOfSuitableTrains(trains, destination);
            consoleHelper.printTrains(list, "List of trains, going to a given destination:");

            // #2 list of trains, going to a given destination
            // and living after given day (date)


            // #3 list of trains with common seats, going to a given destination
        } catch (CreationException e) {
            consoleHelper.printString(e.getMessage());
        }
    }
}
