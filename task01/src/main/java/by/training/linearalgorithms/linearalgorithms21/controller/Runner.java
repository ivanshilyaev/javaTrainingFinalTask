package by.training.linearalgorithms.linearalgorithms21.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static double readData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter double in \"nnn.ddd\" format:");
        double data = scanner.nextDouble();
        if ((Math.abs((int) data) > 999) || (Math.abs(1000 * data - (int) (1000 * data)) > 0))
            throw new InputMismatchException();
        return data;
    }

    public static double transformData(double data) {
        int n = (int) data;
        data = ((int) (data * 1000)) % 1000;
        return data + (double) n / 1000;
    }

    public static void main(String[] args) {
        double data = 0;
        try {
            data = readData();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data");
            System.exit(0);
        }
        System.out.println("Result is " + transformData(data));
    }
}
