package by.training.arrays1.cyclicshift.controller;

import by.training.arrays1.cyclicshift.service.ShiftCommand;

import java.util.Random;

public class Runner {
    private static final int SIZE = 10;

    private static void printArray(int[] array, String message) {
        System.out.println(message);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; ++i) {
            array[i] = 1 + random.nextInt() % 100;
        }
        ShiftCommand command = new ShiftCommand();
        printArray(array, "Source array:");
        command.exec(array, 5, true);
        printArray(array, "Changed array:");
        command.exec(array, 5, true);
        printArray(array, "Returned array");
    }
}
