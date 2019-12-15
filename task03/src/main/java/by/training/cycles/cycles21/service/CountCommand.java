package by.training.cycles.cycles21.service;

public class CountCommand {
    private double f(double x) {
        return x - Math.sin(x);
    }

    public int exec(String data, double[] x, double[] y) {
        String[] array = data.split(" ");
        double a = Double.parseDouble(array[0]);
        double b = Double.parseDouble(array[1]);
        if (b < a) {
            throw new IllegalArgumentException();
        }
        double h = Double.parseDouble(array[2]);
        int size = (int) ((b - a) / h) + 1;
        for (int i = 0; i < size; ++i) {
            x[i] = a + i * h;
            y[i] = f(a + i * h);
        }
        return size;
    }
}
