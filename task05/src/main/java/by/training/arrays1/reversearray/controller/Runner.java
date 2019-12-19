package by.training.arrays1.reversearray.controller;

import java.util.Random;

public class Runner {
    private static final int SIZE = 10;

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; ++i) {
            array[i] = 1 + random.nextInt() % 100;
        }
        System.out.println("Source array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i <= SIZE / 2; ++i) {
            int tmp = array[i];
            array[i] = array[SIZE - i - 1];
            array[SIZE - i - 1] = tmp;
        }
        System.out.println("Reverse array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
