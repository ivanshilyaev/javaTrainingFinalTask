package by.training.arrays1.assignment10.controller;

import by.training.arrays1.assignment10.service.NewArrayCommand;
import by.training.arrays1.assignment05.service.ParseData;
import by.training.arrays1.assignment05.service.exception.ZeroSizeException;
import by.training.arrays1.assignment05.view.ReadData;

public class Runner {
    private static final int SIZE = 10;

    private static void printArray(int[] array, String message) {
        System.out.println(message);
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            String data = new ReadData().read(SIZE);
            int[] array = new ParseData().parse(data, SIZE);
            int[] result = new NewArrayCommand().exec(array);
            printArray(result, "Numbers of the array for which a[i] > i:");
        } catch (ZeroSizeException e) {
            System.out.println(e.getMessage());
        }
    }
}
