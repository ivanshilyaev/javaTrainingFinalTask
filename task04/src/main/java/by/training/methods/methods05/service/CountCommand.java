package by.training.methods.methods05.service;

public class CountCommand {
    public double sumOfMinAndMax(double[] array) {
        return max(array) + min(array);
    }

    private double max(double[] array) {
        double max = array[0];
        for (double value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private double min(double[] array) {
        double min = array[0];
        for (double value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
