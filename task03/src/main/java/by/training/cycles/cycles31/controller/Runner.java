package by.training.cycles.cycles31.controller;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; ++i) {
            array[i] = 1 + (int) (Math.random() * 15);
            while (true) {
                int tmp = 0;
                for (int j = 0; j < i; ++j) {
                    if (array[j] == array[i]) {
                        ++tmp;
                    }
                }
                if (tmp == 0) {
                    break;
                }
                array[i] = 1 + (int) (Math.random() * 15);
            }
        }
        Arrays.sort(array);
        System.out.println("Enter five integers from 1 to 15");
        int[] guess = new int[5];
        try {
            for (int i = 0; i < 5; ++i) {
                guess[i] = Integer.parseInt(scanner.nextLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect data");
        }
        Arrays.sort(guess);
        System.out.println("You guessed right:");
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (guess[i] == array[j]) {
                    System.out.println(array[j]);
                    array[j] = 0;
                    guess[i] = 0;
                    break;
                }
            }
        }
        System.out.println("You didn't guess:");
        for (int i = 0; i < 5; ++i) {
            if (array[i] != 0) {
                System.out.println(array[i]);
            }
        }
        System.out.println("Your wrong answers:");
        for (int i = 0; i < 5; ++i) {
            if (guess[i] != 0) {
                System.out.println(guess[i]);
            }
        }
    }
}