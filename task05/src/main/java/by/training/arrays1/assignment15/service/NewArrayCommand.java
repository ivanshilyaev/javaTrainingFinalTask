package by.training.arrays1.assignment15.service;

import by.training.arrays1.assignment05.service.exception.ZeroSizeException;

public class NewArrayCommand {
    public double[] exec(double[] array, double c, double d) throws ZeroSizeException {
        int size = 0;
        for (double value : array) {
            if (value >= c && value <= d) {
                ++size;
            }
        }
        if (size == 0) {
            throw new ZeroSizeException("No even numbers");
        }
        double[] result = new double[size];
        int j = 0;
        for (double value : array) {
            if (value >= c && value <= d) {
                result[j] = value;
                ++j;
            }
        }
        return result;
    }
}
