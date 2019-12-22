package by.training.sortings.controller;

import by.training.sortings.service.bubblesort.BubbleSortCommand;
import by.training.sortings.service.combsort.CombSortCommand;
import by.training.sortings.service.insertionsort.InsertionSortCommand;
import by.training.sortings.service.oddevensort.OddEvenSortCommand;
import by.training.sortings.service.selectionsort.SelectionSortCommand;
import by.training.sortings.service.shakersort.ShakerSortCommand;

import java.util.Random;

public class Runner {
    private static final int SIZE = 11;

    private static void printArray(int[] array, String message) {
        System.out.println(message);
        for (int i = 0; i < SIZE; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            array[i] = 1 + Math.abs(random.nextInt()) % 100;
        }
        printArray(array, "Source array:");
        InsertionSortCommand command = new InsertionSortCommand();
        command.execAlgorithm(array);
        printArray(array, "Sorted array:");
    }
}
