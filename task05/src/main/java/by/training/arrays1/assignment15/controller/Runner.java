package by.training.arrays1.assignment15.controller;

import by.training.arrays1.assignment05.service.exception.ZeroSizeException;
import by.training.arrays1.assignment15.service.NewArrayCommand;
import by.training.arrays1.assignment15.service.ParseData;
import by.training.arrays1.assignment15.view.ReadData;

import java.util.InputMismatchException;

public class Runner {
    private static final int SIZE = 10;

    private static void printArray(double[] array, String message) {
        System.out.println(message);
        for (double value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            ReadData reader = new ReadData();
            String data = reader.readArray(SIZE);
            double[] array = new ParseData().parse(data, SIZE);
            double c = reader.readDouble();
            double d = reader.readDouble();
            if (c > d) {
                throw new InputMismatchException("Incorrect data");
            }
            double[] result = new NewArrayCommand().exec(array, c, d);
            printArray(result, "Numbers of the array between "
                    + c + " and " + d + ":");
        } catch (ZeroSizeException | NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
