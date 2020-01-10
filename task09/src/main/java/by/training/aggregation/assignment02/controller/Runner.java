package by.training.aggregation.assignment02.controller;

import by.training.aggregation.assignment02.bean.Car;
import by.training.aggregation.assignment02.bean.Wheel;
import by.training.aggregation.assignment02.bean.WheelType;
import by.training.aggregation.assignment02.service.CarService;
import by.training.aggregation.assignment02.view.ConsoleHelper;

public class Runner {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
        Car car = new Car("Ford", "gray", 4);
        consoleHelper.writeLine(car.toString());
        CarService service = new CarService();
        Wheel wheel = new Wheel(19, WheelType.STUDDED);
        service.exchangeWheel(car, 2, wheel);
        consoleHelper.writeLine(service.fillUpTheCar(car));
        consoleHelper.writeLine(service.moveTheCar(car));
        consoleHelper.writeLine(car.toString());
    }
}
