package by.training.cycles.cycles21.controller;

import by.training.cycles.cycles21.service.CountCommand;
import by.training.cycles.cycles21.view.ReadData;

public class Runner {
    public static void main(String[] args) {
        try {
            String data = new ReadData().read();
            double[] x = new double[1000];
            double[] y = new double[1000];
            double size = new CountCommand().exec(data, x, y);
            for (int i = 0; i < size; ++i) {
                System.out.printf("%10f %10f\n", x[i], y[i]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect data");
        }
    }
}
