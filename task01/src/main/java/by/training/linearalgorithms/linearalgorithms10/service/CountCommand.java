package by.training.linearalgorithms.linearalgorithms10.service;

import static java.lang.Math.*;

public class CountCommand {
    public double exec(double x, double y) {
        double denominator = cos(x) - sin(y);
        if ((cos(x * y) == 0) || (denominator == 0))
            throw new IllegalArgumentException("Division by zero");
        return tan(x * y) * (sin(x) + cos(y)) / (denominator);
    }
}
