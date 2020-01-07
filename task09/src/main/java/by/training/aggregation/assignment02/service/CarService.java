package by.training.aggregation.assignment02.service;

import by.training.aggregation.assignment02.bean.Car;
import by.training.aggregation.assignment02.bean.Wheel;

public class CarService {
    public String moveTheCar(Car car) {
        return car.move();
    }

    public String fillUpTheCar(Car car) {
        return car.fillUp();
    }

    public void exchangeWheel(Car car, int number, Wheel wheel) {
        car.setWheel(number, wheel);
    }
}
