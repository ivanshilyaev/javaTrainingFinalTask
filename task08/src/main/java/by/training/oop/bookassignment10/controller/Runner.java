package by.training.oop.bookassignment10.controller;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.creator.TrainCreator;
import by.training.oop.bookassignment10.view.ConsoleHelper;
import by.training.oop.bookassignment10.view.exception.InvalidParameterException;

public class Runner {
    public static void main(String[] args) {
        try {
//        TrainCreator creator = new TrainCreator();
//        ConsoleHelper consoleHelper = new ConsoleHelper();
//        Train[] trains = creator.createTrainArray(10);
//        consoleHelper.printTrains(trains, "Train array");
            ConsoleHelper consoleHelper = new ConsoleHelper();
            Train train = consoleHelper.readTrain();
            consoleHelper.printTrain(train);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }
}
