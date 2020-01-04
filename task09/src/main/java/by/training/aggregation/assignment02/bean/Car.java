package by.training.aggregation.assignment02.bean;

import java.util.Arrays;
import java.util.Objects;

public class Car {
    private String model;
    private String color;
    public Wheel[] wheels = new Wheel[4];
    public Engine engine;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return model.equalsIgnoreCase(car.model) &&
                color.equalsIgnoreCase(car.color) &&
                Arrays.equals(wheels, car.wheels) &&
                engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(model, color, engine);
        result = 31 * result + Arrays.hashCode(wheels);
        return result;
    }

    @Override
    public String toString() {
        return "Car: " +
                "model = '" + model + '\'' +
                ", color = '" + color + '\'' +
                ", wheels = " + Arrays.toString(wheels) +
                ", engine = " + engine;
    }
}
