package by.training.aggregation.assignment02.controller;

import by.training.aggregation.assignment02.bean.Car;
import by.training.aggregation.assignment02.bean.Engine;
import by.training.aggregation.assignment02.bean.Wheel;
import by.training.aggregation.assignment02.bean.WheelType;
import by.training.aggregation.assignment02.view.ConsoleHelper;

public class Runner {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        Car car = new Car("Ford", "gray");
        for (int i = 0; i < 4; ++i) {
            car.wheels[i] = new Wheel(20, WheelType.WINTER);
        }
        car.engine = new Engine(400);
        consoleHelper.writeLine(car.toString());
    }
}
