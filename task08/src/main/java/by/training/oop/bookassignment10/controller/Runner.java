package by.training.oop.bookassignment10.controller;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.creator.TrainCreator;
import by.training.oop.bookassignment10.service.creator.exception.CreationException;
import by.training.oop.bookassignment10.view.ConsoleHelper;

public class Runner {
    public static void main(String[] args) {
        TrainCreator creator = new TrainCreator();
        ConsoleHelper consoleHelper = new ConsoleHelper();
        try {
            Train[] trains = creator.createTrainArray(10);
            consoleHelper.printTrains(trains, "Train array:");
        } catch (CreationException e) {
            consoleHelper.printString(e.getMessage());
        }
    }
}
