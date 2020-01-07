package by.training.aggregation.assignment02.bean;

import java.util.*;

public class Car {
    private String model;
    private String color;
    private int wheelNumber;
    private List<Wheel> wheels;
    private Engine engine;

    public Car(String model, String color, int wheelNumber) {
        this.model = model;
        this.color = color;
        this.wheelNumber = wheelNumber;
        wheels = new LinkedList<>();
        for (int i = 0; i < wheelNumber; ++i) {
            wheels.add(new Wheel(19, WheelType.SUMMER));
        }
        engine = new Engine(300);
    }

    public String move() {
        return engine.start() + "\n" + "The car is moving";
    }

    public String fillUp() {
        return "The car has been filled up (recharged)";
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Wheel getWheel(int number) {
        return wheels.get(number);
    }

    public int calculateWheelNumber() {
        return wheels.size();
    }

    public Engine getEngine() {
        return engine;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWheel(int number, Wheel wheel) {
        wheels.set(number, wheel);
        // колесо, которое было заменено, исчезает ¯\_(ツ)_/¯
        // можно продумать другой сценарий
        // (например, склад колёс и тд)
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(wheels, car.wheels) &&
                Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car: " +
                "model = '" + model + '\'' +
                ", color = '" + color + '\'' +
                ", wheels = " + wheels +
                ", engine = " + engine;
    }
}
