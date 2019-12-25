package by.training.oop.bookassignment10.controller;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.creator.TrainCreator;

public class Runner {
    public static void main(String[] args) {
        Train train = new Train("New York");
        TrainCreator creator = new TrainCreator();
        creator.fillRandomly(train);
        System.out.println(train);
    }
}
