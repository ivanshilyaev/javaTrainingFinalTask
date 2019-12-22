package by.training.methods.methods15.controller;

import by.training.methods.methods15.service.CountCommand;
import by.training.methods.methods15.service.exception.NoSuchNumbersException;
import by.training.methods.methods15.view.ReadData;

import java.util.InputMismatchException;

public class Runner {
    public static void main(String[] args) {
        try {
            int[] array = new ReadData().read();
            int k = array[0];
            int n = array[1];
            int[] result = new CountCommand().exec(k, n);
            System.out.println("Sum of digits of each number is " + k +
                    ", numbers <= " + n);
            for (int value : result) {
                System.out.println(value);
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data");
        } catch (NoSuchNumbersException e) {
            System.out.println(e.getMessage());
        }
    }
}
